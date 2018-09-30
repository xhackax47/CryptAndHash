/**
 * 
 * @author CHAABI Samy
 */

package services;

import java.util.Scanner;

import javax.crypto.Cipher;

import model.Menus;

public class Crypt {
	
	static Scanner sc = new Scanner(System.in);
	static int choixMenuSecret;
	static int choixMenuTopSecret;

	//AES
	public static void secretCrypt() {
		
		do {
		
		Menus.afficheMenuSecret();
		String sSecret = sc.nextLine();
		
		try {
			choixMenuSecret = Integer.parseInt(sSecret);
		} catch (NumberFormatException e) {
			choixMenuSecret = 0;
		}
		
		switch(choixMenuSecret) {
		
		case 1:
			// TO-DO Faire le choix du chemin du fichier avec une variable
			String keyCryptPathAES = "D:\\\\\\eclipse-workspace\\test\\keys\\AESKEY";
			String iCryptFile = "D:\\\\\\eclipse-workspace\\test\\test.pdf";
			String oCryptFile = "D:\\\\\\eclipse-workspace\\test\\testCrypt.cpdf";
			
			System.out.println("");
			System.out.println("Veuillez indiquer le fichier à crypter (AES): ");
			System.out.println("");
			
			AES.generateKey(keyCryptPathAES);
			AES.encryptFile(iCryptFile,oCryptFile,keyCryptPathAES,Cipher.ENCRYPT_MODE);
			break;
		case 2:
			String keyDecryptPathAES = "D:\\\\\\eclipse-workspace\\test\\keys\\AESKEY";
			String iDecryptFile = "D:\\\\\\eclipse-workspace\\test\\testCrypt.cpdf";
			String oDecryptFile = "D:\\\\\\eclipse-workspace\\test\\test.pdf";
			
			System.out.println("");
			System.out.println("Veuillez indiquer le fichier à décrypter (AES): ");
			System.out.println("");
			
			AES.generateKey(keyDecryptPathAES);
			AES.encryptFile(oDecryptFile,iDecryptFile,keyDecryptPathAES,Cipher.DECRYPT_MODE);
			break;
		case 3:
			break;
		default:
			System.out.println("");
			System.out.println("Choix inconnu, veuillez recommencer");
			System.out.println("");
			break;
		}

		
		}while(choixMenuSecret != 3);
	}

	//RSA
	public static void topSecretCrypt() {
		
		Menus.afficheMenuTopSecret();
		String sTopSecret = sc.nextLine();
		
		try {
			choixMenuTopSecret = Integer.parseInt(sTopSecret);
		} catch (NumberFormatException e) {
			choixMenuTopSecret = 0;
		}
		
		switch(choixMenuTopSecret) {
		
		case 1:
			System.out.println("");
			System.out.println("Veuillez indiquer le fichier à crypter (RSA): ");
			System.out.println("");
			break;
		case 2:
			System.out.println("");
			System.out.println("Veuillez indiquer le fichier à décrypter (RSA): ");
			System.out.println("");
			break;
		case 3:
			break;
		default:
			System.out.println("");
			System.out.println("Choix inconnu, veuillez recommencer");
			System.out.println("");
			break;
		}
		
	}

}
