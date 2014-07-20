package server;

import java.util.logging.Logger;

import dal.DAOFactory;

public class UniversityManager {

	private static Logger LOGGER = Logger.getLogger(UniversityManager.class.getName());
	
	public static void main(String[] args){
	
		Server server = new Server();
		new Thread(server).start();

		/*try {
		    Thread.sleep(20 * 1000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		
		LOGGER.info("Stopping Server");
		server.stop();*/
		
	}
	
}
