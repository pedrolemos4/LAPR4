package ajax_server;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author asc@isep.ipp.pt
 */
public class Dashboard {
	static private ServerSocket sock;
	static private InetAddress serverIP;
	static private int serverPort;
	static private DataOutputStream sOut;
	static private DataInputStream sIn;
	static private final String BASE_FOLDER = "www";
	static private boolean flag = true;

	static final AuthorizationService authz = AuthzRegistry.authorizationService();

	public void execute(String address, int porta) {
		Socket cliSock;

		if (address.isEmpty()) {
			System.out.println("INVALID IP-ADDRESS");
			System.exit(1);
		}

		try {
			serverIP = InetAddress.getByName(address);
		} catch (UnknownHostException ex) {
			System.out.println("Invalid SERVER-ADDRESS.");
			System.exit(1);
		}

		try {
			serverPort = porta;
		} catch (NumberFormatException ex) {
			System.out.println("Invalid SERVER-PORT.");
			System.exit(1);
		}

		System.out.println("Connecting to http://" + address + ":" + serverPort + "/");
		try {
			sock = new ServerSocket(serverPort);
		} catch (IOException ex) {
			System.out.println("Failed to connect to provided SERVER-PORT.");
			System.out.println("Application aborted.");
			System.exit(1);
		}
		try {
			while (flag) {
				cliSock = sock.accept();
				DashboardRequest req = new DashboardRequest(cliSock, BASE_FOLDER);
				//sendTestConnection();
				req.start();
				incAccessesCounter();
			}
		} catch (IOException exception) {
			System.out.println("Connectivity error");
			System.exit(1);
		}
	}
	private static String tasks;
	private static int accessesCounter;

	private static synchronized void incAccessesCounter() {
		accessesCounter++;
	}
/*
	public static synchronized void sendTestConnection() throws IOException, ParseException {
		CommunicationProtocolClient newClient = new CommunicationProtocolClient();
		SystemUser systemUser = authz.session().get().authenticatedUser();
		String username = authz.session().get().authenticatedUser().username().toString();
		//  if (!(username == null || username.isEmpty())) {
		if (newClient.establishConnection()) {
			if (newClient.sendMessage(9, username)) {
				byte[] response = newClient.receiveMessage();
				tasks = new String(response, 3, response[2]);
				if ((newClient.sendMessage(1, "103"))) {
					response = newClient.receiveMessage();
					if (response[1] != 2 || !newClient.closeConnection()) {
						System.out.println("Error closing the connection!");
					}
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

 */

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

