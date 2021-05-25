package base.daemon.executor.presentation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ExecutorServer {
    private static final Logger LOGGER = LogManager.getLogger(ExecutorServer.class);

    private static HashMap<Socket, DataOutputStream> cliList = new HashMap<>();

    public static synchronized void sendToAll(int len, byte[] data) throws Exception {
        for (DataOutputStream cOut : cliList.values()) {
            cOut.write(len);
            cOut.write(data, 0, len);
        }

    }

    public static synchronized void addCli(Socket s) throws Exception {
        cliList.put(s, new DataOutputStream(s.getOutputStream()));
    }

    public static synchronized void remCli(Socket s) throws Exception {
        cliList.get(s).write(0);
        cliList.remove(s);
        s.close();
    }

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
            addCli(s);
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
            byte[] data = new byte[300];

            try {
                sIn = new DataInputStream(myS.getInputStream());
                while (true) {
                    nChars = sIn.read();
                    if (nChars == 0) break; // empty line means client wants to exit
                    sIn.read(data, 0, nChars);
                    ExecutorServer.sendToAll(nChars, data);
                }
                // the client wants to exit
                ExecutorServer.remCli(myS);
            } catch (Exception ex) {
                System.out.println("Error");
            }
        }
    }

}