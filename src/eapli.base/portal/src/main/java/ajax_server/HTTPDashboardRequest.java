package ajax_server;

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


	public HTTPDashboardRequest(SSLSocket s, String f) {
		baseFolder=f; sock=s;
		}

	public void run() {
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
	}
}

