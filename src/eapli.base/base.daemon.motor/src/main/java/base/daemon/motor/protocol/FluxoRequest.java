package base.daemon.motor.protocol;

import base.daemon.executor.algorithms.WorkloadBasedAlgorithm;
import base.daemon.motor.algorithms.AlgoritmoTempoMedio;
import base.daemon.motor.algorithms.FirstComeFirstServeAlgorithm;
import eapli.base.AppSettings;
import eapli.base.Application;
import eapli.base.atividade.application.AplicacoesController;
import eapli.base.atividade.domain.Atividade;
import eapli.base.atividade.domain.AtividadeManual;
import eapli.base.atividade.domain.FluxoAtividade;
import eapli.base.atividade.domain.TipoAtividade;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedido.domain.EstadoPedido;
import eapli.base.pedido.repositories.PedidoRepository;
import eapli.base.servico.domain.Servico;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLServerSocket;
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

    private static final Logger LOGGER = LogManager.getLogger(FluxoRequest.class);

    private static final String IP_EXECUTOR = "10.8.0.82";
    private static final int EXECUTOR_PORT = 32510;

    public FluxoRequest(final AplicacoesController controller, final String request) {
        super(controller, request);
    }

    @Override
    public byte[] execute() {
        boolean atividadeManual = false;
        boolean atividadeAutomatica = false;

        try {

            System.setProperty("javax.net.ssl.trustStore", "orgColab.jks");
            System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

            System.setProperty("javax.net.ssl.keyStore", "orgColab.jks");
            System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

            final String algoritmo = Application.settings().getAlgoritmoAtribuirColaboradores();
            final String algoritmoAuto = Application.settings().getAlgoritmoAtribuirTarefaAutomatica();

            String id = request.trim();
            Servico servico = controller.findServico(id);
            List<Colaborador> list = controller.findColaboradoresElegiveis(servico.idCatalogo());
            FluxoAtividade fluxo = controller.getFluxoAtividade(id);
            Set<Atividade> atividadesList = fluxo.atividades();
            int j = 0;
            Thread[] threads = new Thread[list.size()];

            for (Atividade atividade : atividadesList) {
                if (atividade instanceof AtividadeManual && atividade.tipoAtividade().equals(TipoAtividade.APROVACAO)) {
                    controller.updatePedido(id, EstadoPedido.EM_APROVACAO);
                    Colaborador escolhido=createThreads(atividade, servico, list, null, algoritmo,id);
                    atividade.adicionaColaborador(escolhido,atividade);
                    //pedidoRepository.save(atividade);

                } else if (atividade instanceof AtividadeManual && atividade.tipoAtividade().equals(TipoAtividade.REALIZACAO)) {
                    controller.updatePedido(id, EstadoPedido.EM_RESOLUCAO);
                    createThreads(atividade, servico, list, threads, algoritmo,id);
                } else {
                    if (algoritmoAuto.equalsIgnoreCase("FCFS")) {
                        //algoritmo da bia
                    } else {
                        WorkloadBasedAlgorithm wba = new WorkloadBasedAlgorithm(atividade);
                        threads[j] = new Thread(wba);
                        threads[j].start();
                        j++;
                    }

                    controller.updatePedido(id, EstadoPedido.EM_RESOLUCAO);
                    //mandar para o executor
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

                    /*ArrayList<Thread> threads = new ArrayList<>();
                    List<Atividade> atividades = controller.getAtividadesAuto();
                    for (Atividade at : atividades){
                        System.out.println("Connected to server");
                        Thread serverConn = new Thread(new TcpChatCliConn(at, sOut));
                        threads.add(serverConn);
                        serverConn.start();
                    }*/

                    LOGGER.info("Connected to server");

                    Thread serverConn = new Thread(new TcpChatCliConn(sock));
                    serverConn.start();

                    //CodigoUnico cod = new CodigoUnico(id);
                    String caminhoScript = controller.findScriptServico(servico.identity());
                    byte[] idArray = caminhoScript.getBytes();
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

                    /*for (Thread thread : threads) {
                        try {
                            //sOut.write(data); ????????????
                            thread.join();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(FluxoRequest.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }*/

                    controller.updatePedido(id, EstadoPedido.CONCLUIDO);

                    //atividadeAutomatica=true;
                }
            }
            /*byte[] data = new byte[3];
            data[0]=1;
            data[1]=1;
            data[2]=0;*/

            // controller.saveServico(servico);
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

    public Colaborador createThreads(Atividade atividade, Servico servico, List<Colaborador> list, Thread[] threads, String algoritmo,
                              String idPedido) {

        int j=0;
        if (algoritmo.equalsIgnoreCase("FCFS")) {
            Map<Calendar, Colaborador> map = new TreeMap<>();
            for (Colaborador col : list) {
                FirstComeFirstServeAlgorithm fcfs = new FirstComeFirstServeAlgorithm(col, atividade, map,idPedido);
                threads[j] = new Thread(fcfs);
                threads[j].start();
                j++;
            }
        } else {
            AlgoritmoTempoMedio atm = new AlgoritmoTempoMedio(list, atividade, servico.identity());
            atm.createThreads();
            return atm.getColaboradorEscolhido();
        }
        for (Thread t : threads) {
            t.interrupt();
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted!");
            }
        }
        return null;
    }

}

class TcpChatCliConn implements Runnable {


    private static final Logger LOGGER = LogManager.getLogger(FluxoRequest.class);

    private Socket s;
    //private Atividade a;
    private DataInputStream sIn;
    //private DataOutputStream sout;

    public TcpChatCliConn(Socket tcp_s) {
        s = tcp_s;
    }

    /*public TcpChatCliConn(Atividade atividade, DataOutputStream out) {
        a = atividade;
        sout = out;
    }*/


    public void run() {
        byte[] data = new byte[258];

        try {
            /*//String caminhoScript = controller.findScriptServico(servico.identity());
            String caminhoScript = controller.findScriptAtividade(a.identity());
            byte[] idArray = caminhoScript.getBytes();
            int size = idArray.length;
            data[2] = (byte) size;
            data[0] = 0;
            data[1] = 10;

            int amount_of_times = size % 255;

            while (amount_of_times > 1) {
                byte[] info = new byte[255];
                info[0] = 0;
                info[1] = 10;
                for (int k = 0; k < 255; k++) {
                    info[k + 2] = idArray[k];
                }
                sout.write(info);
                size -= 255;
                amount_of_times--;
            }

            for (int i = 0; i < size; i++) {
                data[i + 2] = idArray[i];
            }
*/
            sIn = new DataInputStream(s.getInputStream());
            sIn.read(data);
            //LOGGER.trace("Received message:----\n{}\n----", data);

            if (data[1] == 1) {
                LOGGER.info("Mensagem recebida com sucesso");
                LOGGER.info("Fim da operação");
            }
            //Logger.getLogger(FluxoRequest.class.getName()).log(Level.SEVERE, "Received message:----\n{}\n----", data);
            //sout.write(data); // TALVEZ AQUI
        } catch (IOException ex) {
            LOGGER.info("Client disconnected.");
        }
    }
}