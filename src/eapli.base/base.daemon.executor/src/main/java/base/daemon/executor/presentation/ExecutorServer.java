/*
 * Copyright (c) 2013-2021 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package base.daemon.executor.presentation;

import base.daemon.executor.protocol.ExecutorProtocolMessageParser;
import base.daemon.executor.protocol.ExecutorProtocolRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ExecutorServer {

    private static final int PORT = 35208;
    static final String TRUSTED_STORE = "server_E.jks";
    static final String KEYSTORE_PASS = "forgotten";


    private static final Logger LOGGER = LogManager.getLogger(ExecutorServer.class);

    //private static ServerSocket sock;

    public static void main(String args[]) throws Exception {
        int i;
        SSLServerSocket sockSSL = null;

        // Trust these certificates provided by authorized clients
        System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

        // Use this certificate and private key as server certificate
        System.setProperty("javax.net.ssl.keyStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

        SSLServerSocketFactory sf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        /*try {
            serverIP = InetAddress.getByName(args[0]);
        } catch (UnknownHostException ex) {
            System.out.println("Invalid server specified: " + args[0]);
            System.exit(1);
        }*/

        try {
            sockSSL = (SSLServerSocket) sf.createServerSocket(PORT);
            sockSSL.setNeedClientAuth(true);
        } catch (IOException ex) {
            System.out.println("Server failed to open local port " + PORT);
            System.exit(1);
        }

        System.out.println("Connected to server: " + args[0] + ":" + PORT);


        while (true) {
            Socket s = sockSSL.accept(); // wait for a new client connection request
            //    addCli(s);
            //System.out.println(s.toString());
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
            InetAddress clientIP;

            clientIP = myS.getInetAddress();
            System.out.println("New client connection from " + clientIP.getHostAddress() +
                    ", port number " + myS.getPort());

            byte[] data = new byte[258];

            try (PrintWriter out = new PrintWriter(myS.getOutputStream(), true);
                 DataInputStream sIn = new DataInputStream(myS.getInputStream())) {
                DataOutputStream sOut = new DataOutputStream(myS.getOutputStream());

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
                final ExecutorProtocolRequest request = ExecutorProtocolMessageParser.parse(inputLine, id);
                final String response = request.execute();

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
                LOGGER.trace("Sent message:----\n{}\n----", response);

                if (request.isGoodbye()) {
                    //  break;
                    //  }
                }
            } catch (IOException e) {
                LOGGER.error(e);
            } finally {
                try {
                    System.out.println("Client " + clientIP.getHostAddress() + ", port number: " + myS.getPort() +
                            " disconnected");
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
}
