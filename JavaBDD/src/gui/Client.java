package gui;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
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
	private InputStream in;
	private OutputStream out;
	private boolean isConnected;

	public void connect(InetAddress addr, int port) {

		try {
			socket = new Socket(addr, 65330);
			LOGGER.info("Demande de connexion");
			in = socket.getInputStream();	
			out = socket.getOutputStream();

		} catch (UnknownHostException e) {
			LOGGER.severe("connection error : " + e);
		} catch (IOException e) {
			LOGGER.severe("stream error : " + e);
		}
		
		isConnected = true;
	}
	
	public void sendMessage(Message msg){
		
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;
		ByteArrayOutputStream byos = null;
		
		try {
			byos = new ByteArrayOutputStream();
			bos = new BufferedOutputStream(byos);
			oos = new ObjectOutputStream(bos);
			oos.writeObject(msg);
			out.write(byos.toByteArray());
		} catch (IOException e) {
			LOGGER.severe("[Client] Error IOException : " + e);
		}
		
		finally {
			oos = null;
			bos = null;
			byos = null;
		}
		
	}

}
