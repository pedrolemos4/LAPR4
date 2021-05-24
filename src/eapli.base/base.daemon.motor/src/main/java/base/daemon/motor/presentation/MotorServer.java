package base.daemon.motor.presentation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class MotorServer {
    private static final Logger LOGGER = LogManager.getLogger(MotorServer.class);

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
                   // final BookingProtocolRequest request = BookingProtocolMessageParser.parse(inputLine);
                    //final String response = request.execute();
                    final String response = "Adeus";
                    out.println(response);
                    LOGGER.trace("Sent message:----\n{}\n----", response);
                    /*if (request.isGoodbye()) {
                        break;
                    }*/
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

}

