/**
 * 
 * @author CHAABI Samy
 */

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
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;

public class PublKey {
	
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

}
