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

    private static final Logger LOGGER = LogManager.getLogger(MotorServer.class);

    private static final int MOTOR_PORT = 32508;


    public static void main(String args[]) throws Exception {
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
                String inputLine = new String(data, 2, (int) data[3]);
                while(data[2]==255){
                    data=new byte[258];
                    sIn.read(data,0,258);
                    inputLine = inputLine.concat(new String(data, 2, (int) data[3]));
                }
                int id = data[1];

                final AplicacoesRequest request = AplicacoesMessageParser.parse(inputLine, id);
                final byte[] response = request.execute();


                DataOutputStream sOut = new DataOutputStream(myS.getOutputStream());
                sOut.write(response);

            } catch (final IOException e) {
                LOGGER.error(e);
            }
            finally {
                try {
                    myS.close();
                } catch (final IOException e) {
                    LOGGER.error("While closing the client socket", e);
                }
            }

        }
    }

}
