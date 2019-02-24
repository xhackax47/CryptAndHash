/**
 * 
 * @author CHAABI Samy
 */

package app;

import java.util.Scanner;

import aws.MenusAWS;
import model.Menus;
import services.Crypt;
import services.Hash;

public class CryptHash {

	static int cryptHashON = 0;
	static int choixAWS;
	static int choixGeneral;
	static int choixHash;
	static int choixCrypt;

	public static void start() throws InterruptedException {
		cryptHashON = 1;
		final Scanner sc = new Scanner(System.in);

		System.out.println("Bienvenue dans le programme CryptAndHash");

		// Boucle Choix Programme
		do {
			Menus.menuGeneral();
			String sG = sc.nextLine();

			// Gestion NumberFormatException
			try {
				choixGeneral = Integer.parseInt(sG);
			} catch (NumberFormatException e) {
				choixGeneral = 10; // Entrée dans default et relancement du menu pour nouveau choix
			}

			// Options Menu Général
			switch (choixGeneral) {

			// MENU AWS
			case 0:
				do {
					Menus.menuAWS();
					String sA = sc.nextLine();

					// Gestion NumberFormatException
					try {
						choixAWS = Integer.parseInt(sA);
					} catch (NumberFormatException e) {
						choixAWS = 0;
					}

					switch (choixAWS) {

					case 1:
						MenusAWS.menuAWSEC2();
						break;

					case 2:
						MenusAWS.menuAWSS3();
						break;

					default:
						System.out.println("");
						System.out.println("Choix inconnu, veuillez recommencer");
						System.out.println("");
						break;
					}

				}
				// Condition de fin de boucle Menu AWS
				while (choixAWS != 3);
				break;

			// MENU CRYPTAGE
			case 1:
				do {
					Menus.menuCryptage();
					String sC = sc.nextLine();

					// Gestion NumberFormatException
					try {
						choixCrypt = Integer.parseInt(sC);
					} catch (NumberFormatException e) {
						choixCrypt = 0;
					}

					switch (choixCrypt) {

					case 1:
						Crypt.cryptAES();
						break;

					case 2:
						try {
							Crypt.cryptRSA();
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;

					default:
						System.out.println("");
						System.out.println("Choix inconnu, veuillez recommencer");
						System.out.println("");
						break;
					}

				}
				// Condition de fin de boucle Menu Cryptage
				while (choixCrypt != 3);
				break;

			// MENU HASHAGE
			case 2:
				do {
					Menus.menuHashage();
					String sH = sc.nextLine();

					// Gestion NumberFormatException
					try {
						choixHash = Integer.parseInt(sH);
					} catch (NumberFormatException e) {
						choixHash = 0;
					}

					// Options menu
					switch (choixHash) {
					case 1:
						Hash.md2Hash();
						break;
					case 2:
						Hash.md5Hash();
						break;
					case 3:
						Hash.sha1Hash();
						break;
					case 4:
						Hash.sha2Hash();
						break;
					case 5:
						Hash.sha3Hash();
						break;
					case 6:
						Hash.sha5Hash();
						break;
					// Gestion des erreurs de saisie dans le choix
					default:
						System.out.println("");
						System.out.println("Choix inconnu, veuillez recommencer");
						System.out.println("");
						break;
					}
				}

				// Condition de fin de boucle Menu Hash
				while (choixHash != 7);
				break;

			// Gestion des erreurs de saisie dans le choix
			default:
				System.out.println("");
				System.out.println("Choix inconnu, veuillez recommencer");
				System.out.println("");
				break;
			}

		}

		// Condition de fin de boucle du programme
		while (choixGeneral != 3);

		System.out.println("");
		System.out.println("Au revoir et merci d'avoir utilisé ce programme");
		try {
			Thread.sleep(3 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Nettoyage et fermeture du programme
		sc.close();
		System.out.checkError();
		System.out.flush();
		System.out.close();
		cryptHashON = 0;
	}

	public static int getCryptHashON() {
		return cryptHashON;
	}

}
