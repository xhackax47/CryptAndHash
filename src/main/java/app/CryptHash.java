/**
 * 
 * @author CHAABI Samy
 */

package app;

import java.util.Scanner;

import model.Menus;
import services.Crypt;
import services.Hash;

public class CryptHash {

	static int cryptHashON = 0;

	public static void start() {
		final Scanner sc = new Scanner(System.in);
		int choixHash;
		int choixCrypt;
		int choixAWS;
		int choixGeneral;

		System.out.println("Bienvenue dans le programme CryptAndHash");
		System.out.println("");

		try {
			Thread.sleep(1 * 1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		cryptHashON = 1;

		// Boucle Choix Programme
		do {
			Menus.afficheMenuGeneral();
			String sG = sc.nextLine();

			// Gestion Exception
			try {
				choixGeneral = Integer.parseInt(sG);
			} catch (NumberFormatException e) {
				choixGeneral = 0;
			}

			// Options Menu Général
			switch (choixGeneral) {

			// MENU AWS
			case 0:
				do {
					Menus.afficheMenuAWS();
					String sA = sc.nextLine();

					// Gestion Exception
					try {
						choixAWS = Integer.parseInt(sA);
					} catch (NumberFormatException e) {
						choixAWS = 0;
					}

					switch (choixAWS) {

					case 1:
//						FAIRE LA BOUCLE DES MENUS AWS
						Menus.afficheMenuAWSEC2();
						break;

					case 2:
//						FAIRE LA BOUCLE DES MENUS AWS
						Menus.afficheMenuAWSS3();
						break;

					// Cas de condition de fin de boucle
					case 3:
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
					Menus.afficheMenuCryptage();
					String sC = sc.nextLine();

					// Gestion Exception
					try {
						choixCrypt = Integer.parseInt(sC);
					} catch (NumberFormatException e) {
						choixCrypt = 0;
					}

					switch (choixCrypt) {

					case 1:
						Crypt.secretCrypt();
						break;

					case 2:
						try {
							Crypt.topSecretCrypt();
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					// Cas de condition de fin de boucle
					case 3:
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
					Menus.afficheMenuHashage();
					String sH = sc.nextLine();

					// Gestion Exception
					try {
						choixHash = Integer.parseInt(sH);
					} catch (NumberFormatException e) {
						choixHash = 0;
					}

					System.out.println("");

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
					// Cas de Condition de fin de boucle Menu Hash
					case 7:
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

			// Cas de Condition de fin de boucle du programme
			case 3:
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
		cryptHashON = 0;
		// Nettoyage et fermeture du programme
		sc.close();
		System.out.checkError();
		System.out.flush();
		System.out.close();

	}

	public static int getCryptHashON() {
		return cryptHashON;
	}

}
