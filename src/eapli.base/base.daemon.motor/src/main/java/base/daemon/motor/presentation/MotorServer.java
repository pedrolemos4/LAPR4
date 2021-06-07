package base.daemon.motor.presentation;

import base.daemon.motor.protocol.AplicacoesMessageParser;
import base.daemon.motor.protocol.AplicacoesRequest;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.repositories.ServicoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class MotorServer {
    private static final int PORT = 31507;
    static final String TRUSTED_STORE = "server_J.jks";
    static final String KEYSTORE_PASS = "forgotten";

    private static final Logger LOGGER = LogManager.getLogger(MotorServer.class);

    private static HashMap<Socket, DataOutputStream> cliList = new HashMap<>();

    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servicos();

    public static synchronized void addCli(Socket s) throws Exception {
        cliList.put(s, new DataOutputStream(s.getOutputStream()));
    }

    public static synchronized void remCli(Socket s) throws Exception {
        cliList.get(s).write(0);
        cliList.remove(s);
        s.close();
    }

    public static synchronized void controlFLuxo(int nChars, byte[] data) throws Exception {
        String idServico = new String(data, 3, nChars);
        //criar Código Unico aqui?
        //ir buscar serviço e depois o fluxo
    }


    public static void main(String args[]) throws Exception {
        int i;
        SSLServerSocket sock = null;
        Socket cliSock;

        // Trust these certificates provided by authorized clients
        System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.trustStorePassword",KEYSTORE_PASS);

        // Use this certificate and private key as server certificate
        System.setProperty("javax.net.ssl.keyStore",TRUSTED_STORE);
        System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);

        SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            sock = (SSLServerSocket) sslF.createServerSocket (PORT);
            sock.setNeedClientAuth(true);        }
        catch (IOException ex) {
            System.out.println("Local port number not available.");
            System.exit(1);
        }

        while (true) {
            Socket s = sock.accept(); // wait for a new client connection request
            //    addCli(s);
            Thread cli = new ClientHandler(s);
            cli.start();
        }
    }

    private static class ClientHandler extends Thread {

        private Socket myS;
        private DataInputStream sIn;

        public ClientHandler(Socket s) {
            myS = s;
        }

        @Override
        public void run() {
            int nChars;
            byte[] data = new byte[258];

            try (PrintWriter out = new PrintWriter(myS.getOutputStream(), true);
                    /*BufferedReader in = new BufferedReader(new InputStreamReader(myS.getInputStream()))*/
                 DataInputStream sIn = new DataInputStream(myS.getInputStream())) {

                //String inputLine;
                //while ((inputLine = in.readLine()) != null) {
                sIn.read(data);
                LOGGER.trace("Received message:----\n{}\n----", data);
                String inputLine = new String(data, 2, (int) data[3]);
                int id = (int) data[1];
                System.out.println(id);
                System.out.println(inputLine);
                final AplicacoesRequest request = AplicacoesMessageParser.parse(inputLine, id);
                final byte[] response = request.execute();
                // out.println(response.toString());
                LOGGER.trace("Sent message:----\n{}\n----", response);
                if (request.isGoodbye()) {
                    //  break;
                    //  }
                }
            } catch (final IOException e) {
                LOGGER.error(e);
            } finally {
                try {
                    myS.close();
                } catch (final IOException e) {
                    LOGGER.error("While closing the client socket", e);
                }
            }
            //if(nChars==0) break; // empty line means client wants to exit
            //TcpChatSrv.sendToAll(nChars,data);
            //}
            // the client wants to exit
            //TcpChatSrv.remCli(myS);
            /*} catch (
                    Exception ex) {
                System.out.println("Error");
            }*/
        }
    }
        /*@Override
        public void run() {
            final InetAddress clientIP = clientSocket.getInetAddress();
            LOGGER.debug("Acepted connection from {}:{}", clientIP.getHostAddress(), clientSocket.getPort());

            try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    LOGGER.trace("Received message:----\n{}\n----", inputLine);
                   // final BookingProtocolRequest request = BookingProtocolMessageParser.parse(inputLine);
                    //final String response = request.execute();
                    final String response = "Adeus";
                    out.println(response);
                    LOGGER.trace("Sent message:----\n{}\n----", response);
                    /*if (request.isGoodbye()) {
                        break;
                    }*/
             /*   }
            } catch (final IOException e) {
                LOGGER.error(e);
            } finally {
                try {
                    clientSocket.close();
                } catch (final IOException e) {
                    LOGGER.error("While closing the client socket", e);
                }
            }*/


}

