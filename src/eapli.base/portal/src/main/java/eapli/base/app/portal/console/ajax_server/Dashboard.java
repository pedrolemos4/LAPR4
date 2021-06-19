package eapli.base.app.portal.console.ajax_server;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;


/**
 *
 * @author asc@isep.ipp.pt
 */
public class Dashboard extends Thread {

	private static final Logger LOGGER = LogManager.getLogger(Dashboard.class);

	static final String TRUSTED_STORE = "server_J.jks";
	static final String KEYSTORE_PASS = "forgotten";

	static InetAddress serverIP;
	//private static final String IPMOTOR = "10.8.0.82";
	private static final String IPMOTOR = "localhost";

	static private SSLSocket sock;
	static private int serverPort;

	static private final String BASE_FOLDER = "www";
	static private boolean flag = true;

	static final AuthorizationService authz = AuthzRegistry.authorizationService();
	static ColaboradorRepository repo = PersistenceContext.repositories().colaborador();

	@Override
	public void start() {
		try {
			execute(IPMOTOR,32508);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void execute(String address,int porta) throws IOException {

		final String name = this.authz.session().get().authenticatedUser().username().toString();
		System.out.println("Name: " + name);
		// Trust these certificates provided by servers
		System.setProperty("javax.net.ssl.trustStore", name + ".jks");
		System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

		// Use this certificate and private key for client certificate when requested by the server
		System.setProperty("javax.net.ssl.keyStore", name + ".jks");
		System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

		System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");

		if(doConnection(address,porta)) {
			if (Desktop.isDesktopSupported())
				while (flag) {
					//SSLSocket cliSock = (SSLSocket) sock.accept();
					//sock.startHandshake();
					sendTestConnection();
				}
		}
	}

	public static synchronized void sendTestConnection() throws IOException {
		//try {
			Colaborador colab = repo.findEmailColaborador(authz.session().get().authenticatedUser().email());
			if (sendMessage(5, colab.identity().toString())) {
				tasks = receiveMessage();
			}
		//}catch (Exception e){
			//LOGGER.error("Error trying to send the protocol!");
		//}
	}

	private static boolean doConnection(String address, int porta) {

		SSLSocketFactory sslF = (SSLSocketFactory) SSLSocketFactory.getDefault();

		try {
			serverIP = InetAddress.getByName(address);
			try {
				serverPort = porta;

				LOGGER.info("Connecting to https://"+ IPMOTOR + ":" + serverPort + "/");

				try{
					sock = (SSLSocket) sslF.createSocket(serverIP,serverPort);
					LOGGER.info("Connected to https://"+ IPMOTOR + ":" + serverPort + "/");

					try {
						openDashboard();
						return true;
					} catch (URISyntaxException | IOException e) {
						e.printStackTrace();
						return false;
					}
				}catch (IOException e) {
					LOGGER.error("Failed to connect to https://"+ IPMOTOR + ":" + serverPort + "/");
					e.printStackTrace();
					return false;
				}
			}
			catch(NumberFormatException ex) {
				System.out.println("Invalid SERVER-PORT.");
				return false;
			}
		}
		catch(UnknownHostException ex) {
			System.out.println("Invalid server specified: " + IPMOTOR);
			return false;
		}
	}

	private static void openDashboard() throws URISyntaxException, IOException {
		if (Desktop.isDesktopSupported()) {
			URI uri = new URI("http://localhost:" + serverPort +"/");
			HTTPmessage req = new HTTPmessage();
			req.setContentFromString(getDashboardDataInHTML(),"text/html");
			req.setResponseStatus("ok");
			Desktop.getDesktop().browse(uri); //open url for dashboard
		}
	}

	private static String tasks = "0 0 0 0 0 0 0 0 0 0 0 0 0";
	private static int accessesCounter;

	private static synchronized void incAccessesCounter() {
		accessesCounter++;
	}


	public static synchronized String getDashboardDataInHTML() {
		String[] dashboard = tasks.split(" ");
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
		textHtml = textHtml + "</ul><hr><p>Low Tagged Criticality Tasks: " + dashboard[10] + "</p><hr>";
		textHtml = textHtml + "</ul><hr><p>Medium Tagged Criticality Tasks: " + dashboard[11] + "</p><hr>";
		textHtml = textHtml + "</ul><hr><p>High Tagged Criticality Tasks: " + dashboard[12] + "</p><hr>";
		return textHtml;
	}

	public static void setServerFlag(boolean value) {
		flag = value;
	}

	public static synchronized boolean sendMessage(int num, String input) throws IOException {
		DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());
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


	public static String receiveMessage() throws IOException {
		DataInputStream sIn = new DataInputStream(sock.getInputStream());
		try {
			byte[] data = new byte[258];
			sIn.read(data, 2, 255);
			//System.out.println("Size of info: " + data[2]);
			return new String(data);
		} catch (IOException e) {
			e.printStackTrace();
			return "nao tens tarefas. Bai trabalhar.";
		}
	}
}

