package eapli.base.app.backoffice.console.http;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class HttpServerDashboardFluxo extends Thread {
    static final int PORT = 1904;
    //static final String TRUSTED_STORE = "httpServer.jks";
    static final String KEYSTORE_PASS = "forgotten";
    static private SSLServerSocket sock;
    static private SSLSocket clisock;
    static private boolean flag = true;
    static private final String BASE_FOLDER = "www";
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

    public static boolean doConnection() {
        UserSession session = authz.session().orElseThrow();
        SystemUser systemUser = session.authenticatedUser();
        final String userName = systemUser.username().toString();
        String args [] = new String[1]; //ARGS[0] = IP ADDRESS
        // Trust these certificates provided by authorized clients
        System.setProperty("javax.net.ssl.trustStore", userName + ".jks"); //talvez por server.jks
        System.setProperty("javax.net.ssl.trustStorePassword",KEYSTORE_PASS);

        // Use this certificate and private key as server certificate
        System.setProperty("javax.net.ssl.keyStore", userName + ".jks"); //talvez por server.jks
        System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);

        try {
            SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sock = (SSLServerSocket) sslF.createServerSocket(PORT);
        } catch (IOException ex) {
            System.out.println("Server failed to open local port " + PORT);
            System.exit(1);
        }

        System.out.println("Connected to server: " +  ":" + PORT);
        return true;
    }

    public static synchronized boolean sendMessage(int num, String input) throws IOException {
        DataOutputStream sOut = new DataOutputStream(clisock.getOutputStream());
        byte[] data = new byte[258];

        data[0] = 0;
        data[1] = (byte) num;
        byte[] idArray = input.getBytes();
        data[2] = (byte) idArray.length;
        //colocar caso seja preciso enviar mensagens muito grandes
        /*double amount_of_times = size / 255;
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
        }*/

        for (int i = 0; i < idArray.length; i++) {
            data[i + 2] = idArray[i];
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
