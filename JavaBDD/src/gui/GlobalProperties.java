package gui;
import java.util.ArrayList;
import java.util.HashMap;

public class GlobalProperties {
		
	private static HashMap<String, Object> properties = new HashMap<String, Object>();
	private static ArrayList<String> ValidKeys;
	
	public static void registerProperty(String key, Object value){
		properties.put(key, value);
	}
	
	public static void unregisterProperty(String key){
		properties.remove(key);
	}
	
	public static Object getProperty(String key){
		return properties.get(key);
	}
	
}
