package app;
/**
 * 
 * @author CHAABI Samy
 */

import services.CryptHash;

public class CryptAndHash {

	public static void main(String[] args) {	
		
		// Lancement programme
		CryptHash.start();
		
		// Nettoyage et fermeture du programme
		System.out.checkError();
		System.out.flush();
		System.out.close();
	}

}
