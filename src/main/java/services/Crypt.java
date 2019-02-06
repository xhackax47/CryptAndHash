/**
 * 
 * @author CHAABI Samy
 */

package services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

import javax.crypto.Cipher;

import model.AES;
import model.Menus;
import model.RSA;

public class Crypt {

	final static Scanner sc = new Scanner(System.in);
	static int choixMenuAES;
	static int choixMenuRSA;

	// AES
	public static void cryptAES() {

		do {

			Menus.menuAES();
			String sSecret = sc.nextLine();

			try {
				choixMenuAES = Integer.parseInt(sSecret);
			} catch (NumberFormatException e) {
				choixMenuAES = 0;
			}

			switch (choixMenuAES) {

			case 1:
				// TEST CRYPTAGE AES LIEN EN DUR
				String keyCryptPathAES = "C:\\Users\\Megaport\\git\\CryptAndHash\\testsCrypt\\keys\\AESKEY";
				String iCryptFile = "C:\\Users\\Megaport\\git\\CryptAndHash\\testsCrypt\\test.pdf";
				String oCryptFile = "C:\\Users\\Megaport\\git\\CryptAndHash\\testsCrypt\\testCrypt.cpdf";

				System.out.println("");
				System.out.println("Veuillez indiquer le fichier à crypter (AES): ");
				System.out.println("");

				AES.generateKey(keyCryptPathAES);
				AES.encryptFile(iCryptFile, oCryptFile, keyCryptPathAES, Cipher.ENCRYPT_MODE);
				break;
			case 2:
				// TEST DECRYPTAGE AES LIEN EN DUR
				String keyDecryptPathAES = "C:\\Users\\Megaport\\git\\CryptAndHash\\testsCrypt\\keys\\AESKEY";
				String iDecryptFile = "C:\\Users\\Megaport\\git\\CryptAndHash\\testsCrypt\\testCrypt.cpdf";
				String oDecryptFile = "C:\\Users\\Megaport\\git\\CryptAndHash\\testsCrypt\\test.pdf";

				System.out.println("");
				System.out.println("Veuillez indiquer le fichier à décrypter (AES): ");
				System.out.println("");
				
				// INTEGRER CLASSE DESKTOP AVEC METHODE browse() OU edit() POUR CHOISIR LE FICHIER

				AES.generateKey(keyDecryptPathAES);
				AES.encryptFile(oDecryptFile, iDecryptFile, keyDecryptPathAES, Cipher.DECRYPT_MODE);
				break;
			case 3:
				break;
			default:
				System.out.println("");
				System.out.println("Choix inconnu, veuillez recommencer");
				System.out.println("");
				break;
			}

		} while (choixMenuAES != 3);
	}

	// RSA
	@SuppressWarnings("unused")
	public static void cryptRSA() throws Exception {

		// Génération Clés
		KeyPair keyPair = RSA.generateKeyPair();
		PublicKey pubKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();
		PublKey.sauvegardeClePublique(pubKey, "C:\\Users\\Megaport\\git\\CryptAndHash\\testsCrypt\\pubKey.txt");
		PrivKey.sauvegardeClePrivee(privateKey, "C:\\Users\\Megaport\\git\\CryptAndHash\\testsCrypt\\privateKey.txt");

		Thread.sleep(1 * 1000);

		System.out.println("Clés sauvegardées.");

		do {

			Menus.menuRSA();
			String sTopSecret = sc.nextLine();

			try {
				choixMenuRSA = Integer.parseInt(sTopSecret);
			} catch (NumberFormatException e) {
				choixMenuRSA = 0;
			}

			switch (choixMenuRSA) {

			case 1:
				System.out.println("");
				System.out.println("Veuillez indiquer le fichier à crypter (RSA): ");
				System.out.println("");
				
				// INTEGRER CLASSE DESKTOP AVEC METHODE browse() OU edit() POUR CHOISIR LE FICHIER

				// TEST CRYPTAGE RSA LIEN EN DUR
				File input = new File("C:\\Users\\Megaport\\git\\CryptAndHash\\testsCrypt\\inputCryptRSA.txt");
				File output = new File("C:\\Users\\Megaport\\git\\CryptAndHash\\testsCrypt\\outputCryptRSA.txt");
				FileInputStream fis = new FileInputStream(input);
				FileOutputStream fos = new FileOutputStream(output);			
				break;
			case 2:
				// TEST DECRYPTAGE RSA LIEN EN DUR
				File i2 = new File("C:\\Users\\Megaport\\git\\CryptAndHash\\testsCrypt\\inputCryptRSA.txt");
				File o2 = new File("\"C:\\Users\\Megaport\\git\\CryptAndHash\\testsCrypt\\outputCryptRSA.txt");
				FileInputStream fis2 = new FileInputStream(i2);
				FileOutputStream fos2 = new FileOutputStream(o2);

				System.out.println("");
				System.out.println("Veuillez indiquer le fichier à décrypter (RSA): ");
				System.out.println("");
				
				// INTEGRER CLASSE DESKTOP AVEC METHODE browse() OU edit() POUR CHOISIR LE FICHIER


				// Decryptage fichier
				Cipher cipherDF = Cipher.getInstance("RSA");
				cipherDF.init(Cipher.DECRYPT_MODE, privateKey);
				break;
			case 3:
				
				break;
			default:
				System.out.println("");
				System.out.println("Choix inconnu, veuillez recommencer");
				System.out.println("");
				break;
			}

		} while (choixMenuRSA != 3);

	}

}
