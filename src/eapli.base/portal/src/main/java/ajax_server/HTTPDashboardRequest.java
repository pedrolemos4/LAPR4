package ajax_server;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.colaborador.repositories.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import javax.net.ssl.SSLSocket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author ANDRE MOREIRA (asc@isep.ipp.pt)
 */
public class HTTPDashboardRequest extends Thread {

	String baseFolder;
	SSLSocket sock;
	DataInputStream inS;
	DataOutputStream outS;

	static final AuthorizationService authz = AuthzRegistry.authorizationService();
	ColaboradorRepository repo = PersistenceContext.repositories().colaborador();

	public HTTPDashboardRequest(SSLSocket s, String f) {
		baseFolder=f; sock=s;
		}

	@Override
	public void run() {
		/*
		try {
			outS = new DataOutputStream(sock.getOutputStream());
			inS = new DataInputStream(sock.getInputStream());
		} catch (IOException ex) {
			System.out.println("Thread error on data streams creation");
		}
		try {
			System.out.println("WTF");
			HTTPmessage request = new HTTPmessage(inS);
			HTTPmessage response = new HTTPmessage();
			if (request.getMethod().equals("GET")) {
				if (request.getURI().equals("/votes")) {
					response.setContentFromString(
							Dashboard.getDashboardDataInHTML(), "text/html");
					response.setResponseStatus("200 Ok");
				} else {
					String fullname = "..eapli.base\\portal\\src\\main\\java\\ajax_server\\www";
					if (request.getURI().equals("/")) fullname = fullname + "index.html";
					else fullname = fullname + request.getURI();
					if (response.setContentFromFile(fullname)) {
						response.setResponseStatus("200 Ok");
					} else {
						response.setContentFromString(
								"<html><body><h1>404 File not found</h1></body></html>",
								"text/html");
						response.setResponseStatus("404 Not Found");
					}
				}
				response.send(outS);
			}
		} catch (IOException ex) {
			System.out.println("Thread error when reading request");
		}
		try {
			sock.close();
		} catch (IOException ex) {
			System.out.println("CLOSE IOException");
		}

		 */

		Colaborador colab = repo.findEmailColaborador(authz.session().get().authenticatedUser().email());

		byte[] data = new byte[258];
		data[0] = 0;
		data[1] = 5;
		byte[] idArray = colab.identity().toString().getBytes();
		data[2] = (byte) idArray.length;
		for (int i = 0; i < idArray.length; i++) {
			data[i + 2] = idArray[i];
		}

		try {
			outS.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// serverConn.join();
		try {
			sock.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

