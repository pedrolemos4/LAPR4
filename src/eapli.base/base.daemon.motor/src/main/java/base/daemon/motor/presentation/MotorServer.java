package base.daemon.motor.presentation;

import base.daemon.motor.protocol.AplicacoesMessageParser;
import base.daemon.motor.protocol.AplicacoesRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;

public class MotorServer {
    static final String TRUSTED_STORE = "server_J.jks";
    static final String KEYSTORE_PASS = "forgotten";

    static private final String BASE_FOLDER = "www";

    private static final Logger LOGGER = LogManager.getLogger(MotorServer.class);

    private static final int MOTOR_PORT = 32508;

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
        SSLSocket cliSock;

        // Trust these certificates provided by authorized clients
        System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

        // Use this certificate and private key as server certificate
        System.setProperty("javax.net.ssl.keyStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

        SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            sock = (SSLServerSocket) sslF.createServerSocket(MOTOR_PORT);
            sock.setNeedClientAuth(true);
        } catch (IOException ex) {
            System.out.println("Local port number not available." + MOTOR_PORT);
            System.exit(1);
        }

        while (true) {
            cliSock = (SSLSocket) sock.accept();
            LOGGER.info("Client connected");

            new Thread(new ClientHandler(cliSock)).start();

        }
    }

    private static class ClientHandler extends Thread {

        private Socket myS;

        public ClientHandler(Socket s) {
            myS = s;
        }

        @Override
        public void run() {
            int i = 0;
            byte[] data = new byte[258];
            try (PrintWriter out = new PrintWriter(myS.getOutputStream(), true);
                 DataInputStream sIn = new DataInputStream(myS.getInputStream())) {
                sIn.read(data, 0, 258);
                //System.out.println("Size of info: " + data[2]);
                String inputLine = new String(data, 2, (int) data[3]);
                while(data[2]==255){
                    data=new byte[258];
                    sIn.read(data,0,258);
                    inputLine = inputLine.concat(new String(data, 2, (int) data[3]));
                }
                int id = data[1];
                /*List<byte[]> listBytes = new ArrayList<>();
				int size = sIn.available();
				System.out.println("SIZE: "+size+" "+sIn.read());
                while(size>0){
					System.out.println("Entrou no for");
                    /*byte[] data = new byte[258];
                    //if(sIn.available()<259){
                    sIn.read(data, 0, 258);
                    listBytes.add(data);
					size-=258;
                }
				System.out.println("Passou");
				byte[] aux = new byte[258];
				//System.out.println("listBytes.get(0): "+listBytes.get(0));
				//System.out.println(" listBytes.get(0)[3]"+listBytes.get(0)[3]);
                String inputLine = new String(aux, 2, (int)listBytes.get(0)[3]);
                if(listBytes.size()>1) {
                    for (byte[] b : listBytes) {
                        LOGGER.trace("Received message:----\n{}\n----", b);
                       inputLine = inputLine.concat(new String(b, 2, (int) b[3]));
                    }
                }else{
                    LOGGER.trace("Received message:----\n{}\n----", listBytes.get(0));
                }

                int id = (int) listBytes.get(listBytes.size())[1];*/
                //int id = data[1];
                //String inputLine = new String(data, 2, (int) data[3]);
                final AplicacoesRequest request = AplicacoesMessageParser.parse(inputLine, id);
                final byte[] response = request.execute();

                /*byte[] respostaByte = new byte[258];
                respostaByte[0] = 0;
                respostaByte[1] = 1;
                byte[] respostaByteAux = request.toString().getBytes();
                respostaByte[2] = (byte) respostaByteAux.length;

                for (i = 0; i < respostaByteAux.length; i++) {
                    respostaByte[i + 2] = respostaByteAux[i];
                }*/

                //out.write(respostaByte);
                DataOutputStream sOut = new DataOutputStream(myS.getOutputStream());
                sOut.write(response);
                //out.println(response);

                //System.out.println("STRING: "+response.toString());
                // out.println(response.toString());
                //LOGGER.trace("Sent message:----\n{}\n----", response);
                //if (request.isGoodbye()) {
                //  break;
                //  }
                //}
            } catch (final IOException e) {
                LOGGER.error(e);
            }/*
            finally {
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
