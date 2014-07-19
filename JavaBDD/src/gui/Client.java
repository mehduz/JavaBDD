package gui;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Logger;

import communication.*;

public class Client {

	private static Logger LOGGER = Logger.getLogger(Client.class.getName());

	private Socket socket;
	private InputStream in;
	private OutputStream out;
	private boolean isConnected;

	private Client() {

	}

	private static class SingletonHolder {
		private final static Client instance = new Client();
	}

	public static Client getInstance() {
		return SingletonHolder.instance;
	}

	public void connect(InetAddress addr, int port) {
		if (isConnected)
			return;
		try {
			socket = new Socket(addr, port);
			LOGGER.info("Demande de connexion");
			in = socket.getInputStream();
			out = socket.getOutputStream();
			isConnected = true;
			
		} catch (UnknownHostException e) {
			LOGGER.severe("connection error : " + e);
		} catch (IOException e) {
			LOGGER.severe("stream error : " + e);
		}
		
	}

	public void disconnect() {
		if (!isConnected)
			return;
		try {
			LOGGER.info("Demande de deconnexion");
			in.close();
			out.close();
			socket.close();
		} catch (UnknownHostException e) {
			LOGGER.severe("connection error : " + e);
		} catch (IOException e) {
			LOGGER.severe("stream error : " + e);
		}
		isConnected = false;
	}

	public void sendMessage(Message msg) {

		if (!isConnected) {
			LOGGER.info("Client is not connected");
			return;
		}
		
		ObjectOutputStream oos = null;

		try {
			oos = new ObjectOutputStream(out);
			oos.writeObject(msg);
			oos.close();
			
		} catch (IOException e) {
			LOGGER.severe("[Client] Error IOException : " + e);
		}

		finally {
			oos = null;
		}

	}

}
