package services;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;

public class PrivKey {
	
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

}
