import java.util.Scanner;

import services.Hash;
import model.Menus;

public class CryptHash {

	public static void main(String[] args) {

		final Scanner sc = new Scanner(System.in);
		int choixHash;
		int choixCrypt;
		int choixGeneral;

		System.out.println("BIENVENUE DANS LE PROGRAMME CryptAndHash");
		System.out.println("");

		// Ouverture Boucle Programme
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

					// SECRET LEVEL (AES128)
					case 1:

						break;

					// TOP SECRET LEVEL (AES192 / AES256)
					case 2:

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

		// Nettoyage et fermeture du programme
		System.out.checkError();
		System.out.flush();
		sc.close();
		System.out.close();
	}

}
