package enums;
import java.util.ArrayList;
import java.util.HashMap;

public class GlobalProperties {
		
	private static HashMap<Properties, Object> properties = new HashMap<Properties, Object>();
	
	public static void registerProperty(Properties key, Object value){
		properties.put(key, value);
	}
	
	public static void unregisterProperty(Properties key){
		properties.remove(key);
	}
	
	public static Object getProperty(Properties key){
		return properties.get(key);
	}	
}
