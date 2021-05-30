package ajax_server;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class HttpServerDashboardFluxo {
    static private Socket sock;
    static InetAddress serverIP;
    static private boolean flag = true;
    static final AuthorizationService authz = AuthzRegistry.authorizationService();

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Local port number required at the command line.");
            System.exit(1);
        }
        sendTestConnection();

    }
    // DATA ACCESSED BY THREADS - LOCKING REQUIRED

    private static String estado;

    public static synchronized void sendTestConnection() throws IOException {
        String username = authz.session().get().authenticatedUser().username().toString();
        if (doConnection()) {
            if (sendMessage(4, username)) {
                byte[] response = receiveMessage();
                estado = new String(response, 3, response[3]);
                if ((sendMessage(1, "103"))) {
                    response = receiveMessage();
                    /*if (response[1] != 2 || !closeConnection()) {
                        System.out.println("Error closing the connection!");
                    }*/
                } else {
                    System.out.println("Error trying to send the end connection code!");
                }
            } else {
                System.out.println("Error trying to send the protocol!");
            }
        } else {
            System.out.println("Error trying to connect to the server!");
        }
        //}
    }

    public static boolean doConnection() {
        try {
            serverIP = InetAddress.getByName("10.8.0.83");
        } catch (UnknownHostException ex) {
            System.out.println("Invalid server: " + "endereçoIp");
            return false;
        }

        try {
            sock = new Socket(serverIP, 32507);
        } catch (IOException ex) {
            System.out.println("Failed to connect.");
            return false;
        }
        System.out.println("Connected to server");
        return true;
    }

    public static synchronized boolean sendMessage(int num, String input) throws IOException {
        DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());
        byte[] data = new byte[258];

        data[0] = 0;
        data[1] = (byte) num;
        byte[] idArray = input.getBytes();
        data[2] = (byte) idArray.length;
        for (int i = 0; i < idArray.length; i++) {
            data[i + 2] = idArray[i];
        }

        sOut.write(data);
        return true;
    }

    public static byte[] receiveMessage() throws IOException {
        DataInputStream sIn = new DataInputStream(sock.getInputStream());
        try {
            byte[] answer = new byte[258];
            sIn.read(answer);
            return answer;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static synchronized String getDashboardDataInHTML() {
        String textHtml = "<hr><ul>";
        textHtml = textHtml + "</ul><hr><p>" + estado + "</p><hr>";

        return textHtml;
    }

    public static void setServerFlag(boolean value) {
        flag = value;
    }
}
