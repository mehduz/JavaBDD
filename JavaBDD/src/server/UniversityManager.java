package server;

import java.util.logging.Logger;

import dal.DAOFactory;

public class UniversityManager {

	private static Logger LOGGER = Logger.getLogger(UniversityManager.class.getName());
	
	public static void main(String[] args){
	
		Server server = new Server();
		Thread t  = new Thread(server);
		LOGGER.info("Launching server");
		t.start();

		/*try {
		    Thread.sleep(20 * 1000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		
		LOGGER.info("Stopping Server");
		server.stop();*/
		
	}
	
}
