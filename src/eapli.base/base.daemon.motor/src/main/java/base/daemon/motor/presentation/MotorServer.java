package base.daemon.motor.presentation;

import base.daemon.motor.protocol.AplicacoesMessageParser;
import base.daemon.motor.protocol.AplicacoesRequest;
import eapli.base.AppSettings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MotorServer {
    static final String TRUSTED_STORE = "server_J.jks";
    static final String KEYSTORE_PASS = "forgotten";        

    private static final Logger LOGGER = LogManager.getLogger(MotorServer.class);

    private static final AppSettings appSettings = new AppSettings();

    private static final HashMap<Socket, DataOutputStream> cliList = new HashMap<>();

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
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

        // Use this certificate and private key as server certificate
        System.setProperty("javax.net.ssl.keyStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

        SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        System.out.println(appSettings.getPortMotor());
        try {
            sock = (SSLServerSocket) sslF.createServerSocket(appSettings.getPortMotor());
            sock.setNeedClientAuth(true);
        } catch (IOException ex) {
            System.out.println("Local port number not available." + appSettings.getPortMotor());
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
            int i = 0;
            byte[] data = new byte[258];

            try (PrintWriter out = new PrintWriter(myS.getOutputStream(), true);
                    /*BufferedReader in = new BufferedReader(new InputStreamReader(myS.getInputStream()))*/
                 DataOutputStream sOut = new DataOutputStream(myS.getOutputStream());
                 DataInputStream sIn = new DataInputStream(myS.getInputStream())) {

                List<byte[]> listBytes = new ArrayList<>();
                while (sIn.readBoolean()) {
                    sIn.read(data, i, 258);
                    listBytes.add(data);
                    i++;
                }

                String inputLine = new String(listBytes.get(0), 2, (int)listBytes.get(0)[3]);
                if(listBytes.size()>1) {
                    for (byte[] b : listBytes) {
                        LOGGER.trace("Received message:----\n{}\n----", b);
                        inputLine = inputLine.concat(new String(b, 2, (int) b[3]));
                    }
                }else{
                    LOGGER.trace("Received message:----\n{}\n----", listBytes.get(0));
                }

                int id = /*(int)*/ listBytes.get(listBytes.size())[1];
                final AplicacoesRequest request = AplicacoesMessageParser.parse(inputLine, id);
                final byte[] response = request.execute();

                byte[] respostaByte = new byte[258];
                respostaByte[0] = 0;
                respostaByte[1] = 1;
                byte[] respostaByteAux = request.toString().getBytes();
                respostaByte[2] = (byte) respostaByteAux.length;

                for (i = 0; i < respostaByteAux.length; i++) {
                    respostaByte[i + 2] = respostaByteAux[i];
                }

                sOut.write(respostaByte);

                out.println(response);

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

