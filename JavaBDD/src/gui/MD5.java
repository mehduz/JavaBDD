package gui;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.logging.Logger;

public class MD5 {
	
	private static Logger LOGGER = Logger.getLogger(MD5.class.getName());

	public static String encryptMD5(String str) {
		
		byte[] bytesOfMessage;
		try {
			bytesOfMessage = str.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] thedigest = md.digest(bytesOfMessage);
			return new String(thedigest);
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			LOGGER.severe("Error at encryption : " + e);
		}
		return null;
	}
	
}
