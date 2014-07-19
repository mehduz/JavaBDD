package server;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Logger;

import communication.Dispatcher;
import communication.Message;

public class WorkerRunnable implements Runnable {

	private static Logger LOGGER = Logger.getLogger(WorkerRunnable.class.getName());
	
	protected Socket clientSocket = null;
		
	public WorkerRunnable(Socket clientSocket) {
		super();
		this.clientSocket = clientSocket;
	}

	@Override
	public void run(){
		
		Message msg = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		ByteArrayInputStream bais = null;
		
		try{
			int length = clientSocket.getInputStream().available();
			byte[] response = new byte[length];
			clientSocket.getInputStream().read(response);
			bais = new ByteArrayInputStream(response);
			bis = new BufferedInputStream(bais);
			ois = new ObjectInputStream(bis);
			msg = (Message)ois.readObject();
			Dispatcher.dispatch(msg); 
		}
		catch(IOException | ClassNotFoundException e){
			LOGGER.severe("erreur at reading message : " + e);
		}
		
		Thread.currentThread().interrupt();
		return;
		
	}

}