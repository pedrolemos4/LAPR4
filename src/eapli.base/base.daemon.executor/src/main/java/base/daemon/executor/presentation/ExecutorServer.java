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

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class ExecutorServer {

    private static final Logger LOGGER = LogManager.getLogger(ExecutorServer.class);

    private static ServerSocket sock;

    public static void main(String args[]) throws Exception {
        int i;

        try {
            sock = new ServerSocket(32507);
        } catch (IOException ex) {
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
                final ExecutorProtocolRequest request = ExecutorProtocolMessageParser.parse(inputLine, id);
                final String response = request.execute();
                out.println(response);
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
}
