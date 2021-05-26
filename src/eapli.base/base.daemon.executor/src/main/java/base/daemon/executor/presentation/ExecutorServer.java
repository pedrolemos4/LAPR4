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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server socket for booking daemon.
 *
 * @author Paulo Gandra Sousa 01/06/2020
 *
 */
public class ExecutorServer {
    private static final Logger LOGGER = LogManager.getLogger(ExecutorServer.class);

    /**
     * Client socket.
     *
     * @author Paulo Gandra Sousa 01/06/2020
     *
     */
    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public ClientHandler(final Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            final InetAddress clientIP = clientSocket.getInetAddress();
            LOGGER.debug("Acepted connection from {}:{}", clientIP.getHostAddress(), clientSocket.getPort());

            try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    LOGGER.trace("Received message:----\n{}\n----", inputLine);
                    final ExecutorProtocolRequest request = ExecutorProtocolMessageParser.parse(inputLine);
                    final String response = request.execute();
                    out.println(response);
                    LOGGER.trace("Sent message:----\n{}\n----", response);
                    if (request.isGoodbye()) {
                        break;
                    }
                }
            } catch (final IOException e) {
                LOGGER.error(e);
            } finally {
                try {
                    clientSocket.close();
                } catch (final IOException e) {
                    LOGGER.error("While closing the client socket", e);
                }
            }
        }
    }

    /**
     * Wait for connections.
     *
     * @param port
     */
    @SuppressWarnings("java:S2189")
    private void listen(final int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                final Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket).start();
            }
        } catch (final IOException e) {
            LOGGER.error(e);
        }
    }

    /**
     * Wait for connections.
     *
     * @param port
     * @param blocking
     *            if {@code true} the socket runs in its own thread.
     */
    public void start(final int port, final boolean blocking) {
        if (blocking) {
            listen(port);
        } else {
            new Thread(() -> listen(port)).start();
        }
    }
}
