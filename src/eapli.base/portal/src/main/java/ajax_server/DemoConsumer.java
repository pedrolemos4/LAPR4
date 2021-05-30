package ajax_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author asc@isep.ipp.pt
 */
public class DemoConsumer {
	static private Socket sock;
	static private InetAddress serverIP;
	static private int serverPort;
	static private DataOutputStream sOut;
	static private DataInputStream sIn;

	// THE NUMBER OF VOTES TO CAST ON THE FIRST CANDIDATE
	static private final int VOTES_TO_CAST = 200;

	public void execute(String address, int porta) throws Exception {

		if(address.isEmpty()) {
            		System.out.println("INVALID IP-ADDRESS");
            		System.exit(1);
            		}

		try { serverIP = InetAddress.getByName(address); }
		catch(UnknownHostException ex) {
			System.out.println("Invalid SERVER-ADDRESS.");
			System.exit(1);
			}

		try {serverPort = porta; }
		catch(NumberFormatException ex) {
			System.out.println("Invalid SERVER-PORT.");
			System.exit(1);
			}

		HTTPmessage request = new HTTPmessage();
		request.setRequestMethod("PUT");
		request.setURI("/votes/1");
            	//System.out.println("Casting " + VOTES_TO_CAST + " votes on the first candidate ...");




		//for(int i=0; i<VOTES_TO_CAST; i++) {
		System.out.println("Connecting to http://" + address + ":" + serverPort + "/");
		//try {
			sock = new Socket(serverIP, serverPort);
			System.out.println("Connected to " + serverIP + ":" + serverPort);
		//}
		//catch(IOException ex) {
		//	System.out.println("Failed to connect to provided SERVER-ADDRESS and SERVER-PORT.");
		//	System.out.println("Application aborted.");
		//	System.exit(1);
		}
/*
		try {
			sOut = new DataOutputStream(sock.getOutputStream());
			sIn = new DataInputStream(sock.getInputStream());
		}
		catch(IOException ex) {
			System.out.println("Error accessing socket's streams. Aborted.");
				try { sock.close(); } catch(IOException ex2) { System.out.println("Error closing socket."); }
            			System.out.println("Application aborted.");
            			System.exit(1);
            			}
			request.send(sOut);				// send HTTP request
			HTTPmessage response = new HTTPmessage(sIn);	// receive HTTP response
			//System.out.println("HTTP server response status: " + response.getStatus());
			try { sock.close(); } catch(IOException ex2) { System.out.println("Error closing socket."); }
			}

 */
} // MAIN METHOD
    	//} // CLASS
    
