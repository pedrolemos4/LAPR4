package eapli.base.app.portal.console.ajax_server;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;

import static eapli.base.app.portal.console.ajax_server.HttpServerDashboardFluxo.*;

/**
 *
 * @author asc@isep.ipp.pt
 */
public class Dashboard {

	//static private Socket sock;
	static private SSLServerSocket sock;
	static private InetAddress serverIP;
	static private int serverPort;
	static private DataOutputStream sOut;
	static private DataInputStream sIn;
	static private final String BASE_FOLDER = "www";
	static private boolean flag = true;

	static final AuthorizationService authz = AuthzRegistry.authorizationService();

	public void execute(InetAddress address, int porta) throws Exception {

		SSLSocket cliSock;

		serverIP = address;

		try {
			serverPort = porta;
		}
		catch(NumberFormatException ex) {
			System.out.println("Invalid SERVER-PORT.");
			System.exit(1);
		}

		System.out.println("Connecting to http://" + address.getHostAddress() + ":" + serverPort + "/");

		try{
			SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
			sock = (SSLServerSocket) sslF.createServerSocket(serverPort);
			//sock = new Socket(serverIP, serverPort);
			System.out.println("Connected to " + serverIP.getHostAddress() + ":" + serverPort);
			try {
				openDashboard();
			} catch (URISyntaxException | IOException e) {
				e.printStackTrace();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}

		while (flag) {
			cliSock= (SSLSocket) sock.accept();
			HTTPDashboardRequest req = new HTTPDashboardRequest(cliSock, BASE_FOLDER);
			//sendTestConnection();
			req.start();
			incAccessesCounter();
		}
	}

	private void openDashboard() throws URISyntaxException, IOException {
		URI uri = new URI("http://localhost:35210");
		Desktop.getDesktop().browse(uri); //open url for dashboard
	}

	private static String tasks;
	private static int accessesCounter;

	private static synchronized void incAccessesCounter() {
		accessesCounter++;
	}

	public static synchronized void sendTestConnection() throws IOException {
		String username = authz.session().get().authenticatedUser().username().toString();
		if (doConnection()) {
			if (sendMessage(4, username)) {
				byte[] response = receiveMessage();
				String resp = new String(response, 3, response[3]);
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

	public static synchronized String getDashboardDataInHTML() {
		String[] dashboard = tasks.split("-");
		String textHtml = "<hr><ul>";
		textHtml = textHtml + "</ul><hr><p>Pending tasks: " + dashboard[0] + "</p><hr>";
		textHtml = textHtml + "</ul><hr><p>Over Deadline Tasks: " + dashboard[1] + "</p><hr>";
		textHtml = textHtml + "</ul><hr><p>Almost Deadline Tasks: " + dashboard[2] + "</p><hr>";
		textHtml = textHtml + "</ul><hr><p>High Urgency Tasks: " + dashboard[3] + "</p><hr>";
		textHtml = textHtml + "</ul><hr><p>Medium Urgency Tasks: " + dashboard[4] + "</p><hr>";
		textHtml = textHtml + "</ul><hr><p>Low Urgency Tasks: " + dashboard[5] + "</p><hr>";
		textHtml = textHtml + "</ul><hr><p>Criticality 1 Tasks: " + dashboard[6] + "</p><hr>";
		textHtml = textHtml + "</ul><hr><p>Criticality 2 Tasks: " + dashboard[7] + "</p><hr>";
		textHtml = textHtml + "</ul><hr><p>Criticality 3 Tasks: " + dashboard[8] + "</p><hr>";
		textHtml = textHtml + "</ul><hr><p>Criticality 4 Tasks: " + dashboard[9] + "</p><hr>";
		textHtml = textHtml + "</ul><hr><p>Criticality 5 Tasks: " + dashboard[10] + "</p><hr>";

		//textHtml = textHtml + "</ul><hr><p>HTTP server accesses counter: " + accessesCounter + "</p><hr>";
		return textHtml;
	}

	public static void setServerFlag(boolean value) {
		flag = value;
	}
}

