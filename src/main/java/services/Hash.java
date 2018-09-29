/**
 * 
 * @author CHAABI Samy
 */

package services;

import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;

public class Hash {
	
	static Scanner sc = new Scanner(System.in);

	public static void md2Hash() {
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
	}
	
	public static void md5Hash() {
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
	}
	
	public static void sha1Hash() {
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
	}
	
	public static void sha2Hash() {
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
	}
	
	public static void sha3Hash() {
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
	}
	
	public static void sha5Hash() {
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
	}
}
