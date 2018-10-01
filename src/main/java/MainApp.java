/**
 * 
 * @author CHAABI Samy
 */

import app.CryptHash;

public class MainApp {

	public static void main(String[] args) {	
		
		// Lancement programme
		CryptHash.start();
		
		// Nettoyage et fermeture du programme
		System.out.checkError();
		System.out.flush();
		System.out.close();
	}

}
