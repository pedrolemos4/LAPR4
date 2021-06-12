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

import base.daemon.executor.algorithms.WorkloadController;
import base.daemon.executor.protocol.ExecutorProtocolMessageParser;
import base.daemon.executor.protocol.ExecutorProtocolRequest;
import eapli.base.Application;
import eapli.base.atividade.domain.Atividade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ExecutorServer {

    static final String TRUSTED_STORE = "server_E.jks";
    static final String KEYSTORE_PASS = "forgotten";
    private static final int PORT = 32510;
    private static final String IP = "10.8.0.81";

    private static final List<Atividade> tarefas = new ArrayList<>();

    private static final Logger LOGGER = LogManager.getLogger(ExecutorServer.class);

    private static final WorkloadController controller = new WorkloadController();

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

        try {
            sockSSL = (SSLServerSocket) sf.createServerSocket(PORT);
            sockSSL.setNeedClientAuth(true);
        } catch (IOException ex) {
            System.out.println("Server failed to open local port " + PORT);
            System.exit(1);
        }

        System.out.println("Connected to server: " + IP + ":" + PORT);

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

        public ClientHandler(Socket s) {
            myS = s;
        }

        @Override
        public void run() {
            int i = 0;

            byte[] data = new byte[258];

            try (DataInputStream sIn = new DataInputStream(myS.getInputStream())) {
                DataOutputStream sOut = new DataOutputStream(myS.getOutputStream());

                sIn.read(data, 0, 258);
                //System.out.println("Size of info: " + data[2]);
                String inputLine = new String(data, 2, (int) data[3]);
                while(data[2]==255){
                    data=new byte[258];
                    sIn.read(data,0,258);
                    inputLine = inputLine.concat(new String(data, 2, (int) data[3]));
                }
                int id = data[1];


                final ExecutorProtocolRequest request = ExecutorProtocolMessageParser.parse(inputLine, id);

                //Adicionar Atividade aqui talvez
                //tarefas.add(controller.getTarefaByScript(inputLine));

                final byte[] response = request.execute();

                /*byte[] respostaByte = new byte[258];
                respostaByte[0] = 0;
                respostaByte[1] = 1;
                byte[] respostaByteAux = request.toString().getBytes();
                respostaByte[2] = (byte) respostaByteAux.length;

                for (i = 0; i < respostaByteAux.length; i++) {
                    respostaByte[i + 2] = respostaByteAux[i];
                }*/

                sOut.write(response);

                //out.println(response);
                /*LOGGER.trace("Sent message:----\n{}\n----", response);

                if (request.isGoodbye()) {
                    //  break;
                    //  }
                }*/
            } catch (IOException e) {
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


    public List<Atividade> tarefas(){
        return this.tarefas;
    }

}
