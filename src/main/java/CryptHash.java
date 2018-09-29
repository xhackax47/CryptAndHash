import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;

public class CryptHash {

	public static void main(String[] args) {

		final Scanner sc = new Scanner(System.in);
		int choix;

		// Ouverture Boucle Programme
		do {

			// Menu
			System.out.println("Bienvenue dans Crypt/Hash");
			System.out.println("");
			System.out.println("-------------------------\n");
			System.out.println("1 - MD2 HEX");
			System.out.println("2 - MD5 HEX");
			System.out.println("3 - SHA1 HEX");
			System.out.println("4 - SHA256 HEX");
			System.out.println("5 - SHA384 HEX");
			System.out.println("6 - SHA512 HEX");
			System.out.println("7 - Quitter le programme");
			System.out.println("");
			System.out.println("Choisissez l'algorithme à utiliser : ");
			System.out.println("");
			String s = sc.nextLine();
			
			//Gestion Exception
			try {
				choix = Integer.parseInt(s);
			} catch (NumberFormatException e) {
				choix = 0;
			}
			
			// Options menu
			switch (choix) {

			// Algo MD2
			case 1:
				System.out.println("");
				System.out.println("Veuillez entrer la phrase à crypter/hasher : ");
				System.out.println("");
				String md2String = sc.nextLine();
				String md2Hex = DigestUtils.md2Hex(md2String);
				System.out.println("");
				System.out.println("AVANT HASHAGE : " + md2String);
				System.out.println("");
				System.out.println("APRES HASHAGE MD2-HEX : " + md2Hex);
				System.out.println("");
				break;

			// Algo MD5
			case 2:
				System.out.println("");
				System.out.println("Veuillez entrer la phrase à crypter/hasher : ");
				System.out.println("");
				String md5String = sc.nextLine();
				String md5Hex = DigestUtils.md5Hex(md5String);
				System.out.println("");
				System.out.println("AVANT HASHAGE : " + md5String);
				System.out.println("");
				System.out.println("APRES HASHAGE MD5-HEX : " + md5Hex);
				System.out.println("");
				break;

			// Algo SHA1
			case 3:
				System.out.println("");
				System.out.println("Veuillez entrer la phrase à crypter/hasher : ");
				System.out.println("");
				String sha1String = sc.nextLine();
				String sha1Hex = DigestUtils.sha1Hex(sha1String);
				System.out.println("");
				System.out.println("AVANT HASHAGE : " + sha1String);
				System.out.println("");
				System.out.println("APRES HASHAGE SHA1-HEX : " + sha1Hex);
				System.out.println("");
				break;

			// Algo SHA2
			case 4:
				System.out.println("");
				System.out.println("Veuillez entrer la phrase à crypter/hasher : ");
				System.out.println("");
				String sha2String = sc.nextLine();
				String sha2Hex = DigestUtils.sha256Hex(sha2String);
				System.out.println("");
				System.out.println("AVANT HASHAGE : " + sha2String);
				System.out.println("");
				System.out.println("APRES HASHAGE SHA256-HEX : " + sha2Hex);
				System.out.println("");
				break;

			// Algo SHA3
			case 5:
				System.out.println("");
				System.out.println("Veuillez entrer la phrase à crypter/hasher : ");
				System.out.println("");
				String sha3String = sc.nextLine();
				String sha3Hex = DigestUtils.sha384Hex(sha3String);
				System.out.println("");
				System.out.println("AVANT HASHAGE : " + sha3String);
				System.out.println("");
				System.out.println("APRES HASHAGE SHA384-HEX : " + sha3Hex);
				System.out.println("");
				break;

			// Algo SHA5
			case 6:
				System.out.println("");
				System.out.println("Veuillez entrer la phrase à crypter/hasher : ");
				System.out.println("");
				String sha5String = sc.nextLine();
				String sha5Hex = DigestUtils.sha512Hex(sha5String);
				System.out.println("");
				System.out.println("AVANT HASHAGE : " + sha5String);
				System.out.println("");
				System.out.println("APRES HASHAGE MD2HEX : " + sha5Hex);
				System.out.println("");
				break;

			// Cas de Condition de fin de boucle
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
		// Condition de fin de boucle
		while (choix != 7);

		System.out.println("");
		System.out.println("Au revoir et merci d'avoir utilisé ce programme");

		// Nettoyage et fermeture
		System.out.checkError();
		System.out.flush();
		sc.close();
		System.out.close();
	}

}
