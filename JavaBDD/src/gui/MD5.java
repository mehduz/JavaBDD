package gui;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;
import java.util.Hashtable;
import java.util.logging.Logger;

public class MD5 {
	
	private static Logger LOGGER = Logger.getLogger(MD5.class.getName());

	public static String encryptMD5(String str) {
	
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(str.getBytes());
			byte[] digest = md.digest();
			BigInteger bigInt = new BigInteger(1,digest);
			String hashtext = bigInt.toString(16);
			while(hashtext.length() < 32 ){
			  hashtext = "0"+hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			LOGGER.severe("Error at encryption : " + e);
		}
		return null;
	}	
}