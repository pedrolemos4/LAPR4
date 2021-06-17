package eapli.base.app.backoffice.console.http;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class HttpServerDashboardFluxo extends Thread {
    static InetAddress serverIP;
    static final String KEYSTORE_PASS = "forgotten";
    static private SSLServerSocket sock;
    static private SSLSocket clisock;
    static private boolean flag = true;
    static private final String BASE_FOLDER = "www";
    private static final int MOTOR_PORT = 32508;

    private static final String IPMOTOR = "10.8.0.82";
    static final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    public void start() {
        try {
            sendTestConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (flag) {
            try {
                clisock = (SSLSocket) sock.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            HttpEstadoFluxoRequest req = new HttpEstadoFluxoRequest(clisock, BASE_FOLDER);
            req.start();
        }

    }
    // DATA ACCESSED BY THREADS - LOCKING REQUIRED

    private static String estado;

    public static synchronized void sendTestConnection() throws IOException {
        String username = authz.session().get().authenticatedUser().username().toString();
        if (doConnection()) {
            if (sendMessage(4, username)) {
                byte[] response = receiveMessage();
                estado = new String(response, 3, response[3]);
            } else {
                System.out.println("Error trying to send the protocol!");
            }
        } else {
            System.out.println("Error trying to connect to the server!");
        }
    }

    public static boolean doConnection() throws IOException {
        final String userName = authz.session().get().authenticatedUser().username().toString();
        // Trust these certificates provided by authorized clients
        System.setProperty("javax.net.ssl.trustStore", userName + ".jks");
        System.setProperty("javax.net.ssl.trustStorePassword",KEYSTORE_PASS);

        // Use this certificate and private key as server certificate
        System.setProperty("javax.net.ssl.keyStore", userName + ".jks");
        System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);

        SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();

        try {
            serverIP = InetAddress.getByName(IPMOTOR);
        } catch (UnknownHostException ex) {
            System.out.println("Invalid server specified: " + IPMOTOR);
            System.exit(1);
        }

        try {
            clisock = (SSLSocket) sf.createSocket(serverIP, MOTOR_PORT);
        } catch (IOException ex) {
            System.out.println("Failed to connect to: " + IPMOTOR + ":" + MOTOR_PORT);
            System.out.println("Application aborted.");
            System.exit(1);
        }

        System.out.println("Connected to: " + IPMOTOR + ":" + MOTOR_PORT);

        clisock.startHandshake();
        return true;
    }

    public static synchronized boolean sendMessage(int num, String input) throws IOException {
        DataOutputStream sOut = new DataOutputStream(clisock.getOutputStream());
        byte[] data = new byte[258];

        data[0] = 0;
        data[1] = (byte) num;
        byte[] idArray = input.getBytes();
        int size = idArray.length;
        data[2] = (byte) idArray.length;

        double amount_of_times = size / 255;
        int p = 0;

        while (amount_of_times > 1) {

            byte[] info = new byte[258];
            info[0] = 0;
            info[1] = 10;
            for (int k = 0; k < 255; k++) {
                if (p < size) {
                    info[k + 2] = idArray[p];
                    p++;
                } else {
                    k = 255;
                }
            }
            sOut.write(info);
            size -= 255;
            amount_of_times--;
        }

        for (int i = 0; i < idArray.length; i++) {
            data[i + 2] = idArray[p];
            p++;
        }

        sOut.write(data);
        return true;
    }

    public static byte[] receiveMessage() throws IOException {
        DataInputStream sIn = new DataInputStream(clisock.getInputStream());
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
