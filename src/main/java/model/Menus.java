/**
 * 
 * @author CHAABI Samy
 */

package model;

public class Menus {

	static int menuG, menuC, menuH, menuS, menuTS = 0;

	public static void afficheMenuGeneral() {
		System.out.println("");
		System.out.println("Menu Général");
		System.out.println("");
		System.out.println("-------------------------\n");
		System.out.println("1 - Cryptage Fichier");
		System.out.println("2 - Hashage Chaîne de caratères");
		System.out.println("3 - Quitter le programme");
		System.out.println("");
		System.out.println("Choisissez la fonction à utiliser : ");
		System.out.println("");
		menuG = 1;
	}

	public static void afficheMenuCryptage() {
		System.out.println("");
		System.out.println("CRYPTAGE");
		System.out.println("");
		System.out.println("-------------------------\n");
		System.out.println("1 - Cryptage niveau SECRET (AES)");
		System.out.println("2 - Cryptage niveau TOP-SECRET (RSA)");
		System.out.println("3 - Revenir au menu général");
		System.out.println("");
		System.out.println("Choisissez le niveau à utiliser : ");
		System.out.println("");
		menuC = 1;
	}

	public static void afficheMenuHashage() {
		System.out.println("");
		System.out.println("HASHAGE");
		System.out.println("");
		System.out.println("-------------------------\n");
		System.out.println("1 - MD2 HEX");
		System.out.println("2 - MD5 HEX");
		System.out.println("3 - SHA1 HEX");
		System.out.println("4 - SHA256 HEX");
		System.out.println("5 - SHA384 HEX");
		System.out.println("6 - SHA512 HEX");
		System.out.println("7 - Revenir au menu général");
		System.out.println("");
		System.out.println("Choisissez l'algorithme à utiliser : ");
		System.out.println("");
		menuH = 1;
	}

	public static void afficheMenuSecret() {
		System.out.println("");
		System.out.println("CRYPTAGE SECRET (AES)");
		System.out.println("");
		System.out.println("-------------------------\n");
		System.out.println("1 - Encryptage Fichier");
		System.out.println("2 - Décryptage Fichier");
		System.out.println("3 - Revenir au menu de cryptage");
		System.out.println("");
		menuS = 1;
	}

	public static void afficheMenuTopSecret() {
		System.out.println("");
		System.out.println("CRYPTAGE TOP SECRET (RSA)");
		System.out.println("");
		System.out.println("-------------------------\n");
		System.out.println("1 - Encryptage Fichier");
		System.out.println("2 - Décryptage Fichier");
		System.out.println("3 - Revenir au menu de cryptage");
		System.out.println("");
		menuTS = 1;
	}

	public static int getMenuG() {
		return menuG;
	}

	public static int getMenuC() {
		return menuC;
	}

	public static int getMenuH() {
		return menuH;
	}

	public static int getMenuS() {
		return menuS;
	}

	public static int getMenuTS() {
		return menuTS;
	}

}
