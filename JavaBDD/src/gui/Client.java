package gui;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Logger;

import javax.swing.event.EventListenerList;

import communication.*;

public class Client {

	private static Logger LOGGER = Logger.getLogger(Client.class.getName());

	private Socket socket;
	private InputStream in;
	private OutputStream out;
	private InetAddress serverAddr;
	private int serverPort;
	private boolean isConnected;
	private Reponse reponse;
	private Object lock = new Object();
	private EventListenerList listeners;

	private Client() {
		try {
			serverPort = 65330;
			listeners = new EventListenerList();
<<<<<<< HEAD
			serverAddr = InetAddress.getByName("192.168.1.101");
=======
			serverAddr = InetAddress.getByName("192.168.1.101");
			System.out.println("");
>>>>>>> branch 'master' of https://github.com:443/mehduz/JavaBDD.git
		} catch (Exception e) {
			LOGGER.severe("Client not created, fatal error ! :"  + e);
			serverAddr = InetAddress.getLoopbackAddress();
		}
	}

	private static class SingletonHolder {
		private final static Client instance = new Client();
	}

	public static Client getInstance() {
		return SingletonHolder.instance;
	}

	private void connect() {
		if (isConnected)
			return;
		try {
			socket = new Socket(serverAddr, serverPort);
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
			connect();
		}
		
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			oos = new ObjectOutputStream(out);
			ois = new ObjectInputStream(in);
			oos.writeObject(msg);
			Reponse reponse = (Reponse)ois.readObject();
			if(reponse != null)fireResponse(new ResponseEvent(reponse));
		} catch (Exception e) {
			LOGGER.severe("[Client] Error IOException : " + e);
		}

		finally {
			oos = null;
		}

	}
	 
	public void addListener(ResponseListener rp){
		listeners.add(ResponseListener.class, rp);
	}
	
	public void removeListener(ResponseListener rp){
		listeners.remove(ResponseListener.class, rp);
	}
	
	public void fireResponse(ResponseEvent responseEvent){
		for(ResponseListener rl : listeners.getListeners(ResponseListener.class)){
			rl.onResponseReceived(responseEvent);
		}
	}
}
