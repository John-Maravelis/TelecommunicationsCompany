package mainProject.passwordEncryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Encryption {
	
	public String createSalt() {
		byte[] salt = new byte[1];
		SecureRandom secureRandom = new SecureRandom();
		secureRandom.nextBytes(salt);
		return salt.toString();
	}
	
	//in order to salt the hashed password add: String salt as a parameter and uncomment messageDigeset.update()
	public String generateHash(String unhashedPassword){
		String algorithm = "SHA-256";
		MessageDigest messageDigest = null;

		try {
			messageDigest = MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			return "-";
		}
		
		messageDigest.reset();
		//messageDigest.update(salt.getBytes());
		byte[] hashedPassword = messageDigest.digest(unhashedPassword.getBytes());
    
		return bytesToHexString(hashedPassword);
	}
	
	
	private final static char[] HEX_ARRAY = "0123456789abcdef".toCharArray();
	
	public static String bytesToHexString(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];	
		for(int i=0; i<bytes.length; i++) {
			int j = bytes[i] & 0xFF;
			hexChars[i * 2] = HEX_ARRAY[j >>> 4];
			hexChars[i * 2 + 1] = HEX_ARRAY[j & 0x0F];
		}
		return new String(hexChars);
	}
}
