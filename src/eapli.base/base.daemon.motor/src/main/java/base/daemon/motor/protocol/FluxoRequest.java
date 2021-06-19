package base.daemon.motor.protocol;

import base.daemon.motor.algorithms.AlgoritmoTempoMedio;
import base.daemon.motor.algorithms.ExecutorController;
import base.daemon.motor.algorithms.FirstComeFirstServeAlgorithm;
import base.daemon.motor.algorithms.FirstComeFirstServeExecutor;
import eapli.base.Application;
import eapli.base.atividade.application.AplicacoesController;
import eapli.base.atividade.domain.*;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.Label;
import eapli.base.formulario.domain.Variavel;
import eapli.base.formulario.repositories.FormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedido.domain.EstadoPedido;
import eapli.base.pedido.domain.Pedido;
import eapli.base.pedido.repositories.PedidoRepository;
import eapli.base.servico.domain.Servico;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;

public class FluxoRequest extends AplicacoesRequest {

    static final String KEYSTORE_PASS = "forgotten";
    static InetAddress serverIP;
    static SSLSocket sock;

    private final PedidoRepository pedidoRepository = PersistenceContext.repositories().pedidos();
    private final FormularioRepository formularioRepository = PersistenceContext.repositories().formularios();

    private static final Logger LOGGER = LogManager.getLogger(FluxoRequest.class);

    private static final int EXECUTOR_PORT = 32510;


    public FluxoRequest(final AplicacoesController controller, final String request) {
        super(controller, request);
    }

    @Override
    public byte[] execute() {

        try {

            System.setProperty("javax.net.ssl.trustStore", "motor.jks");
            System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

            System.setProperty("javax.net.ssl.keyStore", "motor.jks");
            System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

            final String algoritmo = Application.settings().getAlgoritmoAtribuirColaboradores().trim();
            final String algoritmoAuto = Application.settings().getAlgoritmoAtribuirTarefaAutomatica().trim();

            String id = request.trim();
            Pedido pedido = pedidoRepository.findPedido(id);
            Servico servico = controller.findServico(id);
            List<Colaborador> list = controller.findColaboradoresElegiveis(servico.idCatalogo());
            //FluxoAtividade fluxo = controller.getFluxoAtividade(id);
            List<Atividade> atividadesList = pedidoRepository.getListaAtividades(id, EstadoAtividade.PENDENTE);
            System.out.println("\n\n\n\n\n\n\n" + atividadesList.size() + "\n\n\n\n\n\n\n\n\n\n");
            int j = 0;
            Thread[] threads = new Thread[list.size()];

            j = 0;
            for (Atividade atividade : atividadesList) {
                if (atividade instanceof AtividadeManual && atividade.tipoAtividade().equals(TipoAtividade.APROVACAO)) {
                    controller.updatePedido(id, EstadoPedido.EM_APROVACAO);
                    Colaborador escolhido = createThreads(atividade, servico, list, algoritmo, id);
                    pedido.adicionaColaborador(escolhido, atividade);
                    pedidoRepository.save(pedido);

                } else if (atividade instanceof AtividadeManual && atividade.tipoAtividade().equals(TipoAtividade.REALIZACAO)) {
                    controller.updatePedido(id, EstadoPedido.EM_RESOLUCAO);
                    Colaborador escolhido = createThreads(atividade, servico, list, algoritmo, id);
                    pedido.adicionaColaborador(escolhido, atividade);
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nPedido: " + pedido.toString());
                    pedidoRepository.save(pedido);
                } else {
                    String ipEscolhido = "";
                    if (algoritmoAuto.equalsIgnoreCase("FCFS")) {
                        System.out.println("BQEEKDN::::  " + ExecutorController.getListExecutores().size());
                        Map<String, Integer> map = ExecutorController.getMapa();
                        List<String> listServidores = ExecutorController.getListExecutores();

                        for(Map.Entry<String, Integer> map1: map.entrySet()){
                            System.out.println("MAPA:: " + map1.getKey());
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        }

                        FirstComeFirstServeExecutor first = new FirstComeFirstServeExecutor(listServidores, atividade, map);
                        first.createThreads();
                        ipEscolhido = first.getExecutorEscolhido();
                        ExecutorController.addAtividade(ipEscolhido);

                        for(Map.Entry<String, Integer> map1: map.entrySet()){
                            System.out.println("MAPA:: " + map1.getKey());
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        }

                    }/* else {
                        WorkloadBasedAlgorithm wba = new WorkloadBasedAlgorithm(atividade);
                        threads[j] = new Thread(wba);
                        threads[j].start();
                        j++;
                    }*/

                    controller.updatePedido(id, EstadoPedido.EM_RESOLUCAO);

                    byte[] data = new byte[258];

                    SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();

                    try {
                        serverIP = InetAddress.getByName(ipEscolhido);
                    } catch (UnknownHostException ex) {
                        LOGGER.info("Invalid server: " + "endereçoIp");
                        System.exit(1);
                    }

                    try {
                        sock = (SSLSocket) sf.createSocket(serverIP, EXECUTOR_PORT);
                    } catch (IOException ex) {
                        LOGGER.info("Failed to connect to: " + ipEscolhido + ":" + EXECUTOR_PORT);
                        LOGGER.info("Application aborted.");
                        System.exit(1);
                    }

                    LOGGER.info("Connected to: " + ipEscolhido + ":" + EXECUTOR_PORT);

                    sock.startHandshake();

                    DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());

                    LOGGER.info("Connected to server");

                    Thread serverConn = new Thread(new TcpChatCliConn(sock));
                    serverConn.start();

                    Script caminhoScript1 = controller.findScriptAtividade(servico.identity());
                    String caminhoScript = caminhoScript1.toString();
                    Formulario form = pedidoRepository.getFormularioPedido(id);

                    List<Atributo> atributos = formularioRepository.findAtributos(form.identity());
                    String input = "";
                    String atributoProdutoColab = "";
                    for (Atributo at : atributos) {
                        Variavel v = formularioRepository.getVariavelDoAtributo(at.identity());
                        Label l = formularioRepository.getLabelDoAtributo(at.identity());
                        if(l.toString().equalsIgnoreCase("Quantidade")){
                            atributoProdutoColab = atributoProdutoColab.concat("Quantidade:"+v.toString());
                        }
                        input = input.concat(";");
                        input = input.concat(v.toString());
                    }
                    input = input.concat("/");
                    input = input.concat(caminhoScript);

                    atributoProdutoColab = atributoProdutoColab.concat(input);
					byte[] idArray = atributoProdutoColab.getBytes();
                    int size = idArray.length;
                    data[0] = 0;
                    data[1] = 9;
                    data[2] = (byte) size;
                    double amount_of_times = size / 255;
                    int p = 0;

                    while (amount_of_times > 1) {

                        byte[] info = new byte[258];
                        info[0] = 0;
                        info[1] = 10;
                        for (int k = 0; k < 255; k++) {
                            if (p < size) {
                                info[k + 2] = idArray[p];
                                p++;
                            } else {
                                k = 255;
                            }
                        }
                        sOut.write(info);
                        size -= 255;
                        amount_of_times--;
                    }

                    for (int i = 0; i < idArray.length; i++) {
                        data[i + 2] = idArray[p];
                        p++;
                    }

                    sOut.write(data);
                    ExecutorController.removeAtividade(ipEscolhido);
                    serverConn.join();
                    sock.close();

                    controller.updatePedido(id, EstadoPedido.CONCLUIDO);
                }
            }
        } catch (final NumberFormatException e) {
            return buildBadRequest("Invalid servico id").getBytes();
        } catch (IOException | InterruptedException e1) {
            e1.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] data = new byte[3];
        data[0] = 1;
        data[1] = 1;
        data[2] = 0;
        return data;
    }


    public Colaborador createThreads(Atividade atividade, Servico servico, List<Colaborador> list, String algoritmo,
                                     String idPedido) {
        if (algoritmo.equalsIgnoreCase("FCFS")) {
            FirstComeFirstServeAlgorithm fcfs = new FirstComeFirstServeAlgorithm(list, atividade, idPedido);
            fcfs.createThreads();
            Colaborador c = fcfs.getColaboradorEscolhido();
            return c;
        } else {
            AlgoritmoTempoMedio atm = new AlgoritmoTempoMedio(list, atividade, servico.identity());
            atm.createThreads();
            Colaborador c = atm.getColaboradorEscolhido();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n Colaborador: " + c.toString() + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            return c;
        }
    }

}

class TcpChatCliConn implements Runnable {


    private static final Logger LOGGER = LogManager.getLogger(FluxoRequest.class);

    private Socket s;
    private DataInputStream sIn;

    public TcpChatCliConn(Socket tcp_s) {
        s = tcp_s;
    }

    public void run() {
        byte[] data = new byte[258];

        try {
            sIn = new DataInputStream(s.getInputStream());
            sIn.read(data);

            if (data[1] == 1) {
                LOGGER.info("Mensagem recebida com sucesso");
                LOGGER.info("Fim da operação");
            }
        } catch (IOException ex) {
            LOGGER.info("Client disconnected.");
        }
    }
}