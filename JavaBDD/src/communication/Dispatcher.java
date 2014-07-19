package communication;

import java.util.HashMap;
import java.util.logging.Logger;

public class Dispatcher {

	private static Logger LOGGER = Logger.getLogger(Dispatcher.class.getName());
	
	private  static HashMap<String, String> actions;
	static{
		actions = new HashMap();
		actions.put(MessageIdentification.class.getName(), ActionIdentification.class.getName());
	}

	public static void dispatch(Message msg){
		String action = actions.get(msg.getType());
		try {
			Class c = Class.forName(action);
			((Action)c.newInstance()).execute();
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
			LOGGER.severe("Error : " + e);
		}
	}
}
