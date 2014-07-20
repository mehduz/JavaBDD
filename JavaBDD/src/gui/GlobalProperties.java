package gui;
import java.util.ArrayList;
import java.util.Dictionary;

public class GlobalProperties {
		
	private static Dictionary<String, Object> properties;
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
