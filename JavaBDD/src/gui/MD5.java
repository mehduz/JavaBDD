package gui;

import java.io.UnsupportedEncodingException;
import java.security.*;

public class MD5 {

	public String encryptMD5(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		
		byte[] bytesOfMessage = str.getBytes("UTF-8");
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] thedigest = md.digest(bytesOfMessage);
		return new String(thedigest);
	
	}
	
}
