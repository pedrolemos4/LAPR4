package eapli.base.app.portal.console.ajax_server;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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


/**
 *
 * @author asc@isep.ipp.pt
 */
public class Dashboard extends Thread {

	private static final Logger LOGGER = LogManager.getLogger(Dashboard.class);

	static final String TRUSTED_STORE = "httpServer.jks";
	static final String KEYSTORE_PASS = "forgotten";

	//static private Socket sock;
	static private SSLServerSocket sock;
	static private SSLSocket cliSock;
	static private InetAddress serverIP;
	static private int serverPort;
	static private DataOutputStream sOut;
	static private DataInputStream sIn;
	static private final String BASE_FOLDER = "www";
	static private boolean flag = true;

	static final AuthorizationService authz = AuthzRegistry.authorizationService();
	static ColaboradorRepository repo = PersistenceContext.repositories().colaborador();

	@Override
	public void start() {
		InetAddress address = null;
		try {
			address = InetAddress.getLocalHost();
			execute(address,1904);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void execute(InetAddress address, int porta) throws IOException {

		sendTestConnection(address,porta);

		while (flag) {
			HTTPDashboardRequest req = new HTTPDashboardRequest(cliSock, BASE_FOLDER);
				/*
				try {
					cliSock.startHandshake();
					LOGGER.info("Handshake Successful");
				}catch (Exception e){
						LOGGER.error("Handshake Failed");
				}
				 */
			req.start();
		}
	}

	private static void openDashboard() throws URISyntaxException, IOException {
		if (Desktop.isDesktopSupported()) {
			URI uri = new URI("https://localhost:1904");
			Desktop.getDesktop().browse(uri); //open url for dashboard
		}
	}

	private static String tasks;
	private static int accessesCounter;

	private static synchronized void incAccessesCounter() {
		accessesCounter++;
	}

	public static synchronized void sendTestConnection(InetAddress address, int porta) throws IOException {
		Colaborador colab = repo.findEmailColaborador(authz.session().get().authenticatedUser().email());
		if (doConnection(address,porta)) {
			if (sendMessage(5, colab.identity().toString())) {
				byte[] response = receiveMessage();
				tasks = new String(response, 3, response[3]);
			} else {
				System.out.println("Error trying to send the protocol!");
			}
		} else {
			System.out.println("Error trying to connect to the server!");
		}
	}

	private static boolean doConnection(InetAddress address, int porta) {
		// Use this certificate and private key as server certificate
		System.setProperty("javax.net.ssl.keyStore",TRUSTED_STORE); //talvez por server.jks
		System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);

		serverIP = address;

		try {
			serverPort = porta;
		}
		catch(NumberFormatException ex) {
			System.out.println("Invalid SERVER-PORT.");
			System.exit(1);
		}

		try{
			System.out.println("Connecting to https://" + address.getHostAddress() + ":" + serverPort + "/");

			SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
			System.out.println(1);
			sock = (SSLServerSocket) sslF.createServerSocket(serverPort);
			System.out.println(2);
			cliSock= (SSLSocket) sock.accept();
			System.out.println(3);
			//sock = new Socket(serverIP, serverPort);
			System.out.println("Connected to " + serverIP.getHostAddress() + ":" + serverPort);

			try {
				openDashboard();
				return true;
			} catch (URISyntaxException | IOException e) {
				e.printStackTrace();
				return false;
			}
		}catch (IOException e) {
			e.printStackTrace();
			return false;
		}
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

	public static synchronized boolean sendMessage(int num, String input) throws IOException {
		DataOutputStream sOut = new DataOutputStream(cliSock.getOutputStream());
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
		DataInputStream sIn = new DataInputStream(cliSock.getInputStream());
		try {
			byte[] answer = new byte[258];
			sIn.read(answer);
			return answer;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}

