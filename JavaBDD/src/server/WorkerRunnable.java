package server;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
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
		
		try{
			
			InputStream is = clientSocket.getInputStream();
			
			while(clientSocket.isConnected()){
				if(is.available() == 0) continue;
				ois = new ObjectInputStream(is);
				msg = (Message)ois.readObject();
				ois.close();
				Dispatcher.dispatch(msg);
			}
		}
		
		catch(IOException | ClassNotFoundException e){
			LOGGER.severe("erreur at reading message : " + e);
		}
		
		Thread.currentThread().interrupt();
		return;
		
	}

}