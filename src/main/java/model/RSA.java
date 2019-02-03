/**
 * 
 * @author CHAABI Samy
 */

package model;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;


public class RSA {

	// Generation de paires Clés Publique/Privée

	public static KeyPair generateKeyPair() {
		final int keySize = 2048;
		KeyPairGenerator keyPairGenerator = null;
		try {
			keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(keySize);
		} catch (NoSuchAlgorithmException e) {
			System.err.println("Erreur lors de la génération de clés : " + e);
		}

		return keyPairGenerator.genKeyPair();
	}


//	// Encryptage message
//	
//    public static byte[] encrypt(PrivateKey privateKey, String message) throws Exception {
//        Cipher cipher = Cipher.getInstance("RSA");  
//        cipher.init(Cipher.ENCRYPT_MODE, privateKey);  
//
//        return cipher.doFinal(message.getBytes());  
//    }
//    
//	// Decryptage message
//    
//    public static byte[] decrypt(PublicKey publicKey, byte [] encrypted) throws Exception {
//        Cipher cipher = Cipher.getInstance("RSA");  
//        cipher.init(Cipher.DECRYPT_MODE, publicKey);
//        
//        return cipher.doFinal(encrypted);
//    }

}
