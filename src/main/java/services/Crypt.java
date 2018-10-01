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

import model.Menus;

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
				String keyCryptPathAES = "D:\\\\\\eclipse-workspace\\test\\keys\\AESKEY";
				String iCryptFile = "D:\\\\\\eclipse-workspace\\test\\test.pdf";
				String oCryptFile = "D:\\\\\\eclipse-workspace\\test\\testCrypt.cpdf";

				System.out.println("");
				System.out.println("Veuillez indiquer le fichier à crypter (AES): ");
				System.out.println("");

				AES.generateKey(keyCryptPathAES);
				AES.encryptFile(iCryptFile, oCryptFile, keyCryptPathAES, Cipher.ENCRYPT_MODE);
				break;
			case 2:
				String keyDecryptPathAES = "D:\\\\\\eclipse-workspace\\test\\keys\\AESKEY";
				String iDecryptFile = "D:\\\\\\eclipse-workspace\\test\\testCrypt.cpdf";
				String oDecryptFile = "D:\\\\\\eclipse-workspace\\test\\test.pdf";

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
		RSA.sauvegardeClePublique(pubKey, "pubKey.txt");
		RSA.sauvegardeClePrivee(privateKey, "privateKey.txt");

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

				File input = new File("inputCryptRSA.txt");
				File output = new File("outputCryptRSA.txt");
				FileInputStream fis = new FileInputStream(input);
				FileOutputStream fos = new FileOutputStream(output);
				break;
			case 2:
				File i2 = new File("inputCryptRSA.txt");
				File o2 = new File("outputCryptRSA.txt");
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
				// Cryptage fichier
				File i3 = new File("inputCryptRSA.txt");
				File o3 = new File("outputCryptRSA.txt");
				FileInputStream fis3 = new FileInputStream(i3);
				FileOutputStream fos3 = new FileOutputStream(o3);

				System.out.println("");
				System.out.println("Veuillez indiquer le message à crypter (RSA): ");
				System.out.println("");

				PublicKey clePublique = RSA.lectureClePublique("pubKey.txt");
				byte[] bytes = null;

				// Cryptage message
				Cipher cipherE = Cipher.getInstance("RSA");

				String stringOriginal = new String(sc.nextLine());
				SealedObject encrypted = new SealedObject(stringOriginal, cipherE);

				cipherE.init(Cipher.ENCRYPT_MODE, clePublique);
				bytes = cipherE.doFinal(stringOriginal.getBytes());

				FileOutputStream f = new FileOutputStream("Msgencrypted.txt");
				f.write(bytes);
				f.close();

				System.out.println("");
				System.out.println("Message original : ");
				System.out.println("");
				System.out.println(stringOriginal);
				System.out.println("");
				System.out.println("Message encrypté RSA : ");
				System.out.println(f);
				System.out.println("");
				System.out.println("");

				break;
			case 4:
				System.out.println("");
				System.out.println("Veuillez indiquer le message à décrypter (RSA): ");
				System.out.println("");
				// Cryptage message

				Cipher cipherD = Cipher.getInstance("RSA");
				cipherD.init(Cipher.DECRYPT_MODE, privateKey);

				String stringEncrypted = new String(sc.nextLine());
				SealedObject decrypted = new SealedObject(stringEncrypted, cipherD);
				System.out.println("Message original encrypté RSA : ");
				System.out.println("");
				System.out.println(stringEncrypted);
				System.out.println("");
				System.out.println("Message décrypté  : ");
				System.out.println(decrypted.getAlgorithm());
				System.out.println("");
				System.out.println("");
				break;
			case 5:
				break;
			default:
				System.out.println("");
				System.out.println("Choix inconnu, veuillez recommencer");
				System.out.println("");
				break;
			}

		} while (choixMenuTopSecret != 5);

	}

}
