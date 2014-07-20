package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Logger;


import communication.Dispatcher;
import communication.Message;
import communication.Reponse;

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
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		
		try{ 
			InputStream is = clientSocket.getInputStream();
			OutputStream os = clientSocket.getOutputStream();
			ois = new ObjectInputStream(is);
			oos = new ObjectOutputStream(os);
			msg = (Message)ois.readObject();
			Reponse reponse = Dispatcher.dispatch(msg);
			oos.writeObject(reponse);
		}
		catch(Exception e){
			LOGGER.severe("erreur at reading message : " + e);
		}
		finally{
			Thread.currentThread().interrupt();
		}
	}

}