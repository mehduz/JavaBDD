package gui;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
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
