package base.daemon.motor.protocol;

import eapli.base.atividade.application.AplicacoesController;
import eapli.base.atividade.domain.*;
import eapli.base.pedido.domain.EstadoPedido;
import eapli.base.servico.domain.Servico;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Set;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class FluxoRequest extends AplicacoesRequest {

    private AuthorizationService authz = AuthzRegistry.authorizationService();
    static final String KEYSTORE_PASS = "forgotten";
    private static final int CODIGO_MOTOR = 10;
    static InetAddress serverIP;
    static SSLSocket sock;
    static SSLServerSocket s;

    private static final String IPMOTOR = "10.8.0.81";
    private static final int MOTOR_PORT = 32510;

    public FluxoRequest(final AplicacoesController controller, final String request/*, final String servicoId*/) {
        super(controller, request);
        //  this.servicoId = servicoId;
    }

    @Override
    public byte[] execute() {
        boolean atividadeManual=false;
        boolean atividadeAutomatica=false;

        try {
            // Trust these certificates provided by servers
            System.setProperty("javax.net.ssl.trustStore", "motor.jks");
            System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

            // Use this certificate and private key for client certificate when requested by the server
            System.setProperty("javax.net.ssl.keyStore", "motor.jks");
            System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);


            String id = request.trim();
            System.out.println("Id: " + id);
            Servico servico = controller.findServico(id);
            FluxoAtividade fluxo = controller.getFluxoAtividade(id);
            Set<Atividade> atividadesList = fluxo.atividades();
            for (Atividade atividade : atividadesList) {
                if (atividade instanceof AtividadeManual) {
                    if (atividade.tipoAtividade().equals(TipoAtividade.APROVACAO)) {
                        controller.updatePedido(id, EstadoPedido.EM_APROVACAO);
                    } else {
                        controller.updatePedido(id, EstadoPedido.EM_RESOLUCAO);
                        //fazer atividade resolução
                    }

                    //atividadeManual=true;
                    //new TcpChatCliConn(s);
                    //return data;
                } else {
                    controller.updatePedido(id, EstadoPedido.EM_RESOLUCAO);
                    //mandar para o executor
                    byte[] data = new byte[258];

                    SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();

                    try {
                        serverIP = InetAddress.getByName(IPMOTOR);
                    } catch (UnknownHostException ex) {
                        System.out.println("Invalid server: " + "endereçoIp");
                        System.exit(1);
                    }

                    try {
                        sock = (SSLSocket) sf.createSocket(serverIP, MOTOR_PORT);
                    } catch (IOException ex) {
                        System.out.println("Failed to connect to: " + IPMOTOR + ":" + MOTOR_PORT);
                        System.out.println("Application aborted.");
                        System.exit(1);
                    }

                    System.out.println("Connected to: " + IPMOTOR + ":" + MOTOR_PORT);

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

                    System.out.println("Connected to server");
                    Thread serverConn = new Thread(new TcpChatCliConn(sock));
                    serverConn.start();

                    //CodigoUnico cod = new CodigoUnico(id);
                    String caminhoScript = controller.findScriptServico(servico.identity());
                    byte[] idArray = caminhoScript.getBytes();
                    int size = idArray.length;
                    data[0] = 0;
                    data[1] = 9;
                    data[2] = (byte) size;
                    double amount_of_times = size/255;
                    int p=0;

                    while (amount_of_times > 1) {

                        byte[] info = new byte[258];
                        info[0] = 0;
                        info[1] = 10;
                        for (int k = 0; k < 255; k++) {
                            if(p<size){
                                info[k + 2] = idArray[p];
                                p++;
                            }else{
                                k=255;
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
        data[0]=1;
        data[1]=1;
        data[2]=0;
        return data;
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

            if(data[1]==1) {
                System.out.println("Sucesso");
            }
            //Logger.getLogger(FluxoRequest.class.getName()).log(Level.SEVERE, "Received message:----\n{}\n----", data);
            //sout.write(data); // TALVEZ AQUI
        } catch (IOException ex) {
            System.out.println("Client disconnected.");
        }
    }
}