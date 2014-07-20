package gui;
import java.util.Dictionary;

public class GlobalProperties {
		
	private static Dictionary<String, Object> properties;
	
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
