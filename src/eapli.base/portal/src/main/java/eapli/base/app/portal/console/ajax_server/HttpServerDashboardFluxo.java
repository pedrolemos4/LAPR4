package eapli.base.app.portal.console.ajax_server;

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

public class HttpServerDashboardFluxo {
    static final int PORT = 35210;
    static final String KEYSTORE_PASS = "forgotten";
    static private SSLSocket clisock;
    static private SSLServerSocket sock;
    static private boolean flag = true;
    static private final String BASE_FOLDER = "www";
    static final AuthorizationService authz = AuthzRegistry.authorizationService();

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Local port number required at the command line.");
            System.exit(1);
        }

        sendTestConnection();

        while (flag) {
            clisock = (SSLSocket) sock.accept();
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
        SSLServerSocket sockSSL;
        final String userName = systemUser.name().firstName() + " " + systemUser.name().lastName();
        String args [] = new String[1]; //ARGS[0] = IP ADDRESS
        // Trust these certificates provided by authorized clients
        System.setProperty("javax.net.ssl.trustStore", userName + ".jks");
        System.setProperty("javax.net.ssl.trustStorePassword",KEYSTORE_PASS);

        // Use this certificate and private key as server certificate
        System.setProperty("javax.net.ssl.keyStore",userName + ".jks");
        System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);

        SSLServerSocketFactory sf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sock = (SSLServerSocket) sslF.createServerSocket(Integer.parseInt(args[0]));
        } catch (IOException ex) {
            System.out.println("Server failed to open local port " + PORT);
            System.exit(1);
        }

        System.out.println("Connected to server: " + args[0] + ":" + PORT);
        return true;
    }

    public static synchronized boolean sendMessage(int num, String input) throws IOException {
        DataOutputStream sOut = new DataOutputStream(clisock.getOutputStream());
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
