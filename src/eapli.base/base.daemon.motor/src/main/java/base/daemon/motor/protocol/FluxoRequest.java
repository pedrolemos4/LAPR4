package base.daemon.motor.protocol;

import base.daemon.executor.algorithms.WorkloadBasedAlgorithm;
import base.daemon.executor.presentation.ExecutorServer;
import base.daemon.motor.algorithms.AlgoritmoTempoMedio;
import base.daemon.motor.algorithms.FirstComeFirstServeAlgorithm;
import eapli.base.Application;
import eapli.base.atividade.application.AplicacoesController;
import eapli.base.atividade.domain.*;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
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

    private static final String IP_EXECUTOR = "10.8.0.81";
    private static final int EXECUTOR_PORT = 32510;

    public FluxoRequest(final AplicacoesController controller, final String request) {
        super(controller, request);
    }

    @Override
    public byte[] execute() {

        try {

            System.setProperty("javax.net.ssl.trustStore", "orgColab.jks");
            System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

            System.setProperty("javax.net.ssl.keyStore", "orgColab.jks");
            System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

            final String algoritmo = Application.settings().getAlgoritmoAtribuirColaboradores();
            final String algoritmoAuto = Application.settings().getAlgoritmoAtribuirTarefaAutomatica();

            String id = request.trim();
            Pedido pedido = pedidoRepository.findPedido(id);
            Servico servico = controller.findServico(id);
            List<Colaborador> list = controller.findColaboradoresElegiveis(servico.idCatalogo());
            //FluxoAtividade fluxo = controller.getFluxoAtividade(id);
            List<Atividade> atividadesList = pedidoRepository.getListaAtividades(id, EstadoAtividade.PENDENTE);
            System.out.println("\n\n\n\n\n\n\n" + atividadesList.size() + "\n\n\n\n\n\n\n\n\n\n");
            int j = 0;
            Thread[] threads = new Thread[list.size()];
			
			j=0;
            for (Atividade atividade : atividadesList) {
                if (atividade instanceof AtividadeManual && atividade.tipoAtividade().equals(TipoAtividade.APROVACAO)) {
                    controller.updatePedido(id, EstadoPedido.EM_APROVACAO);
                    Colaborador escolhido=createThreads(atividade, servico, list, algoritmo,id);
                    pedido.adicionaColaborador(escolhido,atividade);
                    pedidoRepository.save(pedido);

                } else if (atividade instanceof AtividadeManual && atividade.tipoAtividade().equals(TipoAtividade.REALIZACAO)) {
                    controller.updatePedido(id, EstadoPedido.EM_RESOLUCAO);
                    Colaborador escolhido = createThreads(atividade, servico, list,algoritmo, id);
                    pedido.adicionaColaborador(escolhido,atividade);
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nPedido: "+pedido.toString());
                    pedidoRepository.save(pedido);
                } else {
                  /*  if (algoritmoAuto.equalsIgnoreCase("FCFS")) {
                        //algoritmo da bia
                    } else {
                        WorkloadBasedAlgorithm wba = new WorkloadBasedAlgorithm(atividade);
                        threads[j] = new Thread(wba);
                        threads[j].start();
                        j++;
                    }*/

                    controller.updatePedido(id, EstadoPedido.EM_RESOLUCAO);

                    byte[] data = new byte[258];

                    SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();

                    try {
                        serverIP = InetAddress.getByName(IP_EXECUTOR);
                    } catch (UnknownHostException ex) {
                        LOGGER.info("Invalid server: " + "endereçoIp");
                        System.exit(1);
                    }

                    try {
                        sock = (SSLSocket) sf.createSocket(serverIP, EXECUTOR_PORT);
                    } catch (IOException ex) {
                        LOGGER.info("Failed to connect to: " + IP_EXECUTOR + ":" + EXECUTOR_PORT);
                        LOGGER.info("Application aborted.");
                        System.exit(1);
                    }

                    LOGGER.info("Connected to: " + IP_EXECUTOR + ":" + EXECUTOR_PORT);

                    sock.startHandshake();

                    DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());

                    LOGGER.info("Connected to server");

                    Thread serverConn = new Thread(new TcpChatCliConn(sock));
                    serverConn.start();

                    String caminhoScript = controller.findScriptServico(servico.identity());
                    Formulario form = pedidoRepository.getFormularioPedido(id);
                    List<Atributo> atributos = formularioRepository.findAtributos(form.identity());
                    String input="";
                    for(Atributo at : atributos){
                        input.concat(";");
                        input.concat(formularioRepository.getVariavelDoAtributo(at.identity()).toString());
                    }
                    input.concat("/");
                    input.concat(caminhoScript);
                    byte[] idArray = input.getBytes();
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
                    serverConn.join();
                    sock.close();

                    controller.updatePedido(id, EstadoPedido.CONCLUIDO);
                }
				for(j=0;j<list.size();j++){
					System.out.println("Colaboradores: "+list.get(j).toString());
				}
            }
        } catch (final NumberFormatException e) {
            return buildBadRequest("Invalid servico id").getBytes();
        } catch (IOException | InterruptedException e1) {
            e1.printStackTrace();
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
            return fcfs.getColaboradorEscolhido();
        } else {
            AlgoritmoTempoMedio atm = new AlgoritmoTempoMedio(list, atividade, servico.identity());
            atm.createThreads();
			Colaborador c = atm.getColaboradorEscolhido();
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n Colaborador: "+c.toString()+"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
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