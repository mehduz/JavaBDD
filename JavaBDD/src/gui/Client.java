package gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Logger;

import server.Server;

public class Client {

	private static Logger LOGGER = Logger.getLogger(Client.class.getName());

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private boolean isConnected;

	public void connect(InetAddress addr, int port) {

		try {
			socket = new Socket(addr, 65330);
			LOGGER.info("Demande de connexion");
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));	
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

		} catch (UnknownHostException e) {
			LOGGER.severe("connection error : " + e);
		} catch (IOException e) {
			LOGGER.severe("stream error : " + e);
		}
		
		isConnected = true;
	}
	
	public boolean login(String username, String password){
		
	}
	

}
