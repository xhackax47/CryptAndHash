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
import javax.crypto.SealedObject;

import model.AES;
import model.Menus;
import model.RSA;

public class Crypt {

	final static Scanner sc = new Scanner(System.in);
	static int choixMenuSecret;
	static int choixMenuTopSecret;

	// AES
	public static void secretCrypt() {

		do {

			Menus.afficheMenuSecret();
			String sSecret = sc.nextLine();

			try {
				choixMenuSecret = Integer.parseInt(sSecret);
			} catch (NumberFormatException e) {
				choixMenuSecret = 0;
			}

			switch (choixMenuSecret) {

			case 1:
				// TO-DO Faire le choix du chemin du fichier avec une variable
				String keyCryptPathAES = "D:\\eclipse-workspace\\CryptAndHash\\testsCrypt\\keys\\AESKEY";
				String iCryptFile = "D:\\eclipse-workspace\\CryptAndHash\\testsCrypt\\test.pdf";
				String oCryptFile = "D:\\eclipse-workspace\\CryptAndHash\\testsCrypt\\testCrypt.cpdf";

				System.out.println("");
				System.out.println("Veuillez indiquer le fichier à crypter (AES): ");
				System.out.println("");

				AES.generateKey(keyCryptPathAES);
				AES.encryptFile(iCryptFile, oCryptFile, keyCryptPathAES, Cipher.ENCRYPT_MODE);
				break;
			case 2:
				String keyDecryptPathAES = "D:\\eclipse-workspace\\CryptAndHash\\testsCrypt\\keys\\AESKEY";
				String iDecryptFile = "D:\\eclipse-workspace\\CryptAndHash\\testsCrypt\\testCrypt.cpdf";
				String oDecryptFile = "D:\\eclipse-workspace\\CryptAndHash\\testsCrypt\\test.pdf";

				System.out.println("");
				System.out.println("Veuillez indiquer le fichier à décrypter (AES): ");
				System.out.println("");

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

		} while (choixMenuSecret != 3);
	}

	// RSA
	@SuppressWarnings("unused")
	public static void topSecretCrypt() throws Exception {

		// Génération Clés
		KeyPair keyPair = RSA.generateKeyPair();
		PublicKey pubKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();
		PublKey.sauvegardeClePublique(pubKey, "D:\\eclipse-workspace\\CryptAndHash\\testsCrypt\\pubKey.txt");
		PrivKey.sauvegardeClePrivee(privateKey, "D:\\eclipse-workspace\\CryptAndHash\\testsCrypt\\privateKey.txt");

		Thread.sleep(1 * 1000);

		System.out.println("Clés sauvegardées.");

		do {

			Menus.afficheMenuTopSecret();
			String sTopSecret = sc.nextLine();

			try {
				choixMenuTopSecret = Integer.parseInt(sTopSecret);
			} catch (NumberFormatException e) {
				choixMenuTopSecret = 0;
			}

			switch (choixMenuTopSecret) {

			case 1:
				System.out.println("");
				System.out.println("Veuillez indiquer le fichier à crypter (RSA): ");
				System.out.println("");

				File input = new File("D:\\eclipse-workspace\\CryptAndHash\\testsCrypt\\inputCryptRSA.txt");
				File output = new File("D:\\eclipse-workspace\\CryptAndHash\\testsCrypt\\outputCryptRSA.txt");
				FileInputStream fis = new FileInputStream(input);
				FileOutputStream fos = new FileOutputStream(output);
				
				break;
			case 2:
				File i2 = new File("D:\\eclipse-workspace\\CryptAndHash\\testsCrypt\\inputCryptRSA.txt");
				File o2 = new File("D:\\eclipse-workspace\\CryptAndHash\\testsCrypt\\outputCryptRSA.txt");
				FileInputStream fis2 = new FileInputStream(i2);
				FileOutputStream fos2 = new FileOutputStream(o2);

				System.out.println("");
				System.out.println("Veuillez indiquer le fichier à décrypter (RSA): ");
				System.out.println("");

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

		} while (choixMenuTopSecret != 3);

	}

}
