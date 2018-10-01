package services;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

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

	// Sauvegarde de la clé publique dans un fichier.

	public static void sauvegardeClePublique(PublicKey clePublique, String nomFichier) {
		RSAPublicKeySpec specification = null;
		try {
			KeyFactory usine = KeyFactory.getInstance("RSA");
			specification = usine.getKeySpec(clePublique, RSAPublicKeySpec.class);
		} catch (NoSuchAlgorithmException e) {
			System.err.println("RSA inconnu : " + e);
			System.exit(-1);
		} catch (InvalidKeySpecException e) {
			System.err.println("Cle incorrecte : " + e);
			System.exit(-1);
		}
		
		try {
			ObjectOutputStream fichier = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nomFichier)));
			fichier.writeObject(specification.getModulus());
			fichier.writeObject(specification.getPublicExponent());
			fichier.close();
		} catch (IOException e) {
			System.err.println("Erreur lors de la sauvegarde de la clé : " + e);
			System.exit(-1);
		}
	}

	// Sauvegarde de la clé privée dans un fichier.

	public static void sauvegardeClePrivee(PrivateKey clePrivee, String nomFichier) {
		RSAPrivateKeySpec specification = null;
		try {
			KeyFactory usine = KeyFactory.getInstance("RSA");
			specification = usine.getKeySpec(clePrivee, RSAPrivateKeySpec.class);
		} catch (NoSuchAlgorithmException e) {
			System.err.println("Algorithme RSA inconnu : " + e);
			System.exit(-1);
		} catch (InvalidKeySpecException e) {
			System.err.println("Clé incorrecte : " + e);
			System.exit(-1);
		}

		try {
			ObjectOutputStream fichier = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nomFichier)));
			fichier.writeObject(specification.getModulus());
			fichier.writeObject(specification.getPrivateExponent());
			fichier.close();
		} catch (IOException e) {
			System.err.println("Erreur lors de la sauvegarde de la clé : " + e);
			System.exit(-1);
		}
	}

	// Lecture d'une clé privée depuis un fichier.

	public static PrivateKey lectureClePrivee(String nomFichier) {
		BigInteger modulo = null, exposant = null;
		try {
			@SuppressWarnings("resource")
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nomFichier)));
			modulo = (BigInteger) ois.readObject();
			exposant = (BigInteger) ois.readObject();
		} catch (IOException e) {
			System.err.println("Erreur lors de la lecture de la clé : " + e);
			System.exit(-1);
		} catch (ClassNotFoundException e) {
			System.err.println("Fichier de cle incorrect : " + e);
			System.exit(-1);
		}

		PrivateKey clePrivee = null;
		try {
			RSAPrivateKeySpec specification = new RSAPrivateKeySpec(modulo, exposant);
			KeyFactory usine = KeyFactory.getInstance("RSA");
			clePrivee = usine.generatePrivate(specification);
		} catch (NoSuchAlgorithmException e) {
			System.err.println("Algorithme RSA inconnu : " + e);
			System.exit(-1);
		} catch (InvalidKeySpecException e) {
			System.err.println("Spécification incorrecte : " + e);
			System.exit(-1);
		}
		return clePrivee;
	}

	// Lecture d'une clé publique depuis un fichier.

	public static PublicKey lectureClePublique(String nomFichier) {
		BigInteger modulo = null, exposant = null;
		try {
			@SuppressWarnings("resource")
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nomFichier)));
			modulo = (BigInteger) ois.readObject();
			exposant = (BigInteger) ois.readObject();
		} catch (IOException e) {
			System.err.println("Erreur lors de la lecture de la clé : " + e);
			System.exit(-1);
		} catch (ClassNotFoundException e) {
			System.err.println("Fichier de clé incorrect : " + e);
			System.exit(-1);
		}

		PublicKey clePublique = null;
		try {
			RSAPublicKeySpec specification = new RSAPublicKeySpec(modulo, exposant);
			KeyFactory usine = KeyFactory.getInstance("RSA");
			clePublique = usine.generatePublic(specification);
		} catch (NoSuchAlgorithmException e) {
			System.err.println("Algorithme RSA inconnu : " + e);
			System.exit(-1);
		} catch (InvalidKeySpecException e) {
			System.err.println("Spécification incorrecte : " + e);
			System.exit(-1);
		}
		return clePublique;
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
