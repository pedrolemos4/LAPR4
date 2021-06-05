package base.daemon.motor.protocol;

import eapli.base.atividade.application.AplicacoesController;
import eapli.base.atividade.domain.*;
import eapli.base.equipa.domain.CodigoUnico;
import eapli.base.pedido.domain.EstadoPedido;
import eapli.base.pedido.domain.Pedido;
import eapli.base.servico.domain.Servico;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FluxoRequest extends AplicacoesRequest {
    //private final String servicoId;
    private static final int PORT = 35208;
    static InetAddress serverIP;
    static Socket sock;


    public FluxoRequest(final AplicacoesController controller, final String request/*, final String servicoId*/) {
        super(controller, request);
        //  this.servicoId = servicoId;
    }

    @Override
    public byte[] execute() {
        try {
            String id = request.trim();
            System.out.println("Id: " + id);
            Servico servico = controller.findServico(id);
            FluxoAtividade fluxo = controller.getFluxoAtividade(id);
            for (Atividade atividade : fluxo.atividades()) {
                if (atividade instanceof AtividadeManual) {
                    if (atividade.tipoAtividade().equals(TipoAtividade.APROVACAO)) {
                        controller.updatePedido(id,EstadoPedido.EM_APROVACAO);
                    } else {
                        controller.updatePedido(id,EstadoPedido.EM_RESOLUCAO);
                        //fazer atividade resolução
                    }
                } else {
                    controller.updatePedido(id,EstadoPedido.EM_RESOLUCAO);
                    //mandar para o executor
                    byte[] data = new byte[258];
                    try {
                        serverIP = InetAddress.getLocalHost();
                    } catch (UnknownHostException ex) {
                        System.out.println("Invalid server: " + "endereçoIp");
                        System.exit(1);
                    }

                    try {
                        sock = new Socket(serverIP, PORT);
                    } catch (IOException ex) {
                        System.out.println("Failed to connect.");
                        System.exit(1);
                    }
                    DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());
                    System.out.println("Connected to server");
                    Thread serverConn = new Thread(new TcpChatCliConn(sock));
                    serverConn.start();

                    data[0] = 0;
                    data[1] = 10;
                    //CodigoUnico cod = new CodigoUnico(id);
                    String caminhoScript = controller.findScriptServico(servico.identity());
                    byte[] idArray = caminhoScript.getBytes();
                    data[2] = (byte) idArray.length;
                    for (int i = 0; i < idArray.length; i++) {
                        data[i + 2] = idArray[i];
                    }

                    sOut.write(data);
                    serverConn.join();
                    sock.close();

                    controller.updatePedido(id,EstadoPedido.CONCLUIDO);
                }
            }
           // controller.saveServico(servico);
        } catch (final NumberFormatException e) {
            return buildBadRequest("Invalid servico id").getBytes();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
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
            byte[] data = new byte[300];

            try {
                sIn = new DataInputStream(s.getInputStream());
                sIn.read(data);
                LOGGER.trace("Received message:----\n{}\n----", data);
                String inputLine = new String(data, 2, (int) data[3]);
                int id = (int) data[1];
                System.out.println("Input line: "+inputLine+" Id: "+id);
            } catch (IOException ex) {
                System.out.println("Client disconnected.");
            }
        }
    }


