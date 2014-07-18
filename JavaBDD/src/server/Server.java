package server;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.util.logging.*;

public class Server implements Runnable{

	private static Logger LOGGER = Logger.getLogger(Server.class.getName());
    protected int          serverPort   = 65330;
    protected ServerSocket serverSocket = null;
    protected boolean      isStopped    = false;
    protected Thread       runningThread= null;

  
    public Server(){
    	this(65330);
    }
    
    public Server(int port){
        this.serverPort = port;
    }

    public void run(){
        synchronized(this){
            this.runningThread = Thread.currentThread();
        }
        openServerSocket();
        while(! isStopped()){
            Socket clientSocket = null;
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                if(isStopped()) {
                   LOGGER.info("Server Stopped.") ;
                   return;
                }
                LOGGER.severe("Error accepting client connection" + e.toString()) ;
                throw new RuntimeException(
                    "Error accepting client connection", e);
            }
            new Thread(
                new WorkerRunnable(clientSocket)
            ).start();
        }
        LOGGER.info("Server Stopped.") ;
    }


    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop(){
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
        	LOGGER.info("Error closing server : " + e.toString()) ;
            throw new RuntimeException("Error closing server", e);
        }
    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
        	LOGGER.severe("Cannot open port " + serverPort);
            throw new RuntimeException("Cannot open port" + serverPort, e);
        }
    }

}