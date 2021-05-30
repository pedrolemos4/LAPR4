package http.server;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class HttpChatConsumer {
	private static InetAddress serverIP;
	private static int serverPort;
	public static boolean userExit;
	
	public void execute(String address, String gate) throws Exception {
		String nickName, textLine;

		if(address.isEmpty() || gate.isEmpty()) {
            		System.out.println("Server address and port number required at command line.");
            		System.out.println("Usage: java HttpChatConsumer {SERVER-ADDRESS} {SERVER-PORT-NUMBER}");
            		System.exit(1);
            	}

		try { serverIP = InetAddress.getByName(address); }
		catch(UnknownHostException ex) {
   			System.out.println("Invalid SERVER-ADDRESS: " + address);
    			System.exit(1); }

		try { serverPort = Integer.parseInt(gate); }
		catch(NumberFormatException ex) {
			System.out.println("Invalid SERVER-PORT-NUMBER: " + gate);
			System.exit(1);
			}
		try {
			Socket sock = new Socket(serverIP, serverPort);
			System.out.println("Connected to " + serverIP + ":" + serverPort);
		}
		catch(IOException ex) {
				System.out.println("Failed to connect to provided SERVER-ADDRESS and SERVER-PORT.");
				System.out.println("Application aborted.");
				System.exit(1);
			}

/*
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter your nickname: ");
		nickName = in.readLine();

		userExit=false;

		System.out.println("Press ENTER to fetch all current messages from the server and start chatting.");
		System.out.println("Once chatting, type exit to quit. NOW PRESS ENTER PLEASE.");
		textLine = in.readLine();
		// start a thread to fetch messages from the HTTP server (GET)
		MessageFetcher msgF  = new MessageFetcher(serverIP, serverPort);
		msgF.start();

		while(!userExit) { // read messages from the console and send them to the HTTP server (POST)
			textLine=in.readLine();
			if(textLine.equals("exit")) {
				userExit=true;
				
			}
			else {
				if(!postMessage("(" + nickName + ") " + textLine)) {
					System.out.println("Sorry, server not responding, message not posted");
					// msgF.abort();
				}
			}
		}
		msgF.abort();
		msgF.join();

 */
	} 

	private static boolean postMessage(String msg) {
		Socket TCPconn;
		DataOutputStream sOut;
		DataInputStream sIn;
		try {
			TCPconn = new Socket(serverIP, serverPort);
		}
		catch(IOException ex) {
			return false;
		}
		
		try {
			sOut = new DataOutputStream(TCPconn.getOutputStream());
			sIn = new DataInputStream(TCPconn.getInputStream());
			HTTPmessage request = new HTTPmessage();
			request.setRequestMethod("POST");
			request.setURI("/messages");
			request.setContentFromString(msg, "text/plain");
			request.send(sOut);
			HTTPmessage response = new HTTPmessage(sIn);
			if(!response.getStatus().startsWith("200")) {
				throw new IOException();
			}

		}
		catch(IOException ex) {
			try { TCPconn.close(); } catch(IOException ex2) { }
			return false;
		}
		try { TCPconn.close(); } catch(IOException ex2) { }
		return true;
	}


} // HttpChatConsumer CLASS



class MessageFetcher extends Thread {    
	private	Socket TCPconn;
	private InetAddress serverIP;
	private int serverPort;
	private int nextMessage;

	public MessageFetcher(InetAddress ip, int port) { serverIP=ip; serverPort=port; }

	public void run() {
		nextMessage=0;
		while(!HttpChatConsumer.userExit) {
			String message = getNextMessage();
			if(HttpChatConsumer.userExit) return;
			if(message==null) {
				System.out.println("Server not responding ...");
				nextMessage=0;
				try {Thread.sleep(5000); }
				catch(InterruptedException ie) {
					System.out.println("Thread Interrupted ...");
				}
			}
			else {
				System.out.println(message);
				nextMessage++;
			}
		}
	}
	

	private String getNextMessage() {
		DataOutputStream sOut;
		DataInputStream sIn;
		try {   
			synchronized (serverIP) { TCPconn = new Socket(serverIP, serverPort);}
		}
		catch(IOException ex) {
			synchronized (serverIP) { TCPconn = null;}
			return null;
		}

		HTTPmessage response;
		try {
			sOut = new DataOutputStream(TCPconn.getOutputStream());
			sIn = new DataInputStream(TCPconn.getInputStream());
			HTTPmessage request = new HTTPmessage();
			request.setRequestMethod("GET");
			request.setURI("/messages/" + nextMessage);
			request.send(sOut);
			response = new HTTPmessage(sIn);	// the server may hold the response
			if(!response.getStatus().startsWith("200")) {
				throw new IOException();
			}

		}
		catch(IOException ex) {
			synchronized (serverIP) { 
				try { TCPconn.close(); } catch(IOException ex2) { }
				TCPconn = null;
			}
			return null;
		}
		synchronized (serverIP) { 
			try { TCPconn.close(); } catch(IOException ex2) { }
			TCPconn = null;
		}
		return(new String(response.getContent()));
	}

	public void abort() { // close the socket to force the thread's exit
		synchronized (serverIP) { 
			if(TCPconn==null) return;
			try { TCPconn.close(); } catch(IOException ex2) { }
		}
	}

} // MessageFetcher CLASS




