/**
 * 
 * @author CHAABI Samy
 */

package model;

public class Menus {

	static boolean menuG, menuAWS, menuAWSEC2, menuAWSS3, menuC, menuH, menuS, menuTS = false;

	public static void afficheMenuGeneral() {
		System.out.println("");
		System.out.println("Menu Général");
		System.out.println("");
		System.out.println("-------------------------\n");
		System.out.println("0 - AWS");
		System.out.println("1 - Cryptage Fichier");
		System.out.println("2 - Hashage Chaîne de caratères");
		System.out.println("3 - Quitter le programme");
		System.out.println("");
		System.out.println("Choisissez le service à utiliser : ");
		System.out.println("");
		menuG = true;
	}
	
	public static void afficheMenuAWS() {
		System.out.println("");
		System.out.println("Amazon Web Services");
		System.out.println("");
		System.out.println("-------------------------\n");
		System.out.println("");
		System.out.println("INFO : AVANT DE COMMENCER, PENSER A RENSEIGNER VOS PROPRES ACCESS ET SECURITY KEY DANS LE FICHIER AWSApplicationS3.java :");
		System.out.println("");
		System.out.println("1 - EC2");
		System.out.println("2 - S3");
		System.out.println("3 - Revenir au menu général");
		System.out.println("");
		System.out.println("Choisissez le service AWS à utiliser : ");
		System.out.println("");
		menuAWS = true;
	}
	
	public static void afficheMenuAWSEC2() {
		System.out.println("");
		System.out.println("Amazon Web Services - Elastic Compute Cloud");
		System.out.println("");
		System.out.println("-------------------------\n");
		System.out.println("1 - Creer une machine virtuelle");
		System.out.println("2 - Supprimer une machine virtuelle");
		System.out.println("3 - Se connecter à une VM");
		System.out.println("4 - Revenir au menu général");
		System.out.println("");
		System.out.println("Choix : ");
		System.out.println("");
		menuAWSEC2 = true;
	}
	
	public static void afficheMenuAWSS3() {
		System.out.println("");
		System.out.println("Amazon Web Services - Simple Storage Service");
		System.out.println("");
		System.out.println("-------------------------\n");
		System.out.println("1 - Creer un conteneur");
		System.out.println("2 - Lister les conteneurs");
		System.out.println("3 - Supprimer un conteneur");
		System.out.println("4 - Uploader un objet sur un conteneur");
		System.out.println("5 - Lister les objets d'un conteneur");
		System.out.println("6 - Telecharger un objet d'un conteneur");
		System.out.println("7 - Copier un objet d'un conteneur");
		System.out.println("8 - Supprimer un objet d'un conteneur");
		System.out.println("9 - Supprimer plusieurs objets d'un conteneur");
		System.out.println("0 - Revenir au menu général");
		System.out.println("");
		System.out.println("Choix : ");
		System.out.println("");
		menuAWSS3 = true;
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
		menuC = true;
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
		menuH = true;
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
		System.out.println("Choisissez la fonction à utiliser : ");
		System.out.println("");
		menuS = true;
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
		System.out.println("Choisissez la fonction à utiliser : ");
		System.out.println("");
		menuTS = true;
	}

	public static boolean isMenuG() {
		return menuG;
	}

	public static void setMenuG(boolean menuG) {
		Menus.menuG = menuG;
	}

	public static boolean isMenuAWS() {
		return menuAWS;
	}

	public static void setMenuAWS(boolean menuAWS) {
		Menus.menuAWS = menuAWS;
	}

	public static boolean isMenuAWSEC2() {
		return menuAWSEC2;
	}

	public static void setMenuAWSEC2(boolean menuAWSEC2) {
		Menus.menuAWSEC2 = menuAWSEC2;
	}

	public static boolean isMenuAWSS3() {
		return menuAWSS3;
	}

	public static void setMenuAWSS3(boolean menuAWSS3) {
		Menus.menuAWSS3 = menuAWSS3;
	}

	public static boolean isMenuC() {
		return menuC;
	}

	public static void setMenuC(boolean menuC) {
		Menus.menuC = menuC;
	}

	public static boolean isMenuH() {
		return menuH;
	}

	public static void setMenuH(boolean menuH) {
		Menus.menuH = menuH;
	}

	public static boolean isMenuS() {
		return menuS;
	}

	public static void setMenuS(boolean menuS) {
		Menus.menuS = menuS;
	}

	public static boolean isMenuTS() {
		return menuTS;
	}

	public static void setMenuTS(boolean menuTS) {
		Menus.menuTS = menuTS;
	}

}
