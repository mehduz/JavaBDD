package server;

import java.net.Socket;

public class WorkerRunnable implements Runnable {

	protected Socket clientSocket = null;
		
	public WorkerRunnable(Socket clientSocket) {
		super();
		this.clientSocket = clientSocket;
	}

	@Override
	public void run(){
		
	}

}