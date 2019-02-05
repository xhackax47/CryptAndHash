package aws;

import java.io.IOException;
import java.util.Scanner;

import model.Menus;

public class MenusAWS {

	private static int choixEC2;
	private static int choixS3;
	final static Scanner sc = new Scanner(System.in);

	public static void menuAWSEC2() {
		do {
			Menus.afficheMenuAWSEC2();
			String sEC2 = sc.nextLine();

			// Gestion NumberFormatException
			try {
				choixEC2 = Integer.parseInt(sEC2);
			} catch (NumberFormatException e) {
				choixEC2 = 0;
			}

			switch (choixEC2) {

			case 1:
				break;

			case 2:
				break;

			case 3:
				break;

			case 4:
				break;

			default:
				System.out.println("");
				System.out.println("Choix inconnu, veuillez recommencer");
				System.out.println("");
				break;
			}
		}

		while (choixEC2 != 4);
	}

	public static void menuAWSS3() throws InterruptedException {
		do {
			Menus.afficheMenuAWSS3();
			String sS3 = sc.nextLine();

			// Gestion NumberFormatException
			try {
				choixS3 = Integer.parseInt(sS3);
			} catch (NumberFormatException e) {
				choixS3 = 0;
			}

			switch (choixS3) {
			
			case 0:
				System.out.println("Merci d'avoir utilisé les fonctionnalités AWS de ce programme.");
				Thread.sleep(2*1000);

			case 1:
				System.out.println("");
				System.out.println("CREATION CONTENEUR S3");
				System.out.println("");
				System.out.println("Veuillez indiquer le nom du conteneur à créer :");
				System.out.println("");
				String bucketName = sc.nextLine();
				AWSApplicationS3.createBucket(bucketName);
				Thread.sleep(1*1000);
				System.out.println("Le conteneur " + bucketName + " a été crée avec succès.");
				Thread.sleep(1*1000);
				break;

			case 2:
				System.out.println("");
				System.out.println("LISTE DES CONTENEURS S3");
				System.out.println("");
				AWSApplicationS3.listAllBuckets();
				Thread.sleep(3*1000);
				break;

			case 3:
				System.out.println("");
				System.out.println("SUPPRESSION CONTENEUR S3");
				System.out.println("");
				System.out.println("Veuillez indiquer le nom du conteneur à supprimer :");
				System.out.println("");
				String bucketNameDel = sc.nextLine();
				System.out.println("");
				AWSApplicationS3.deleteBucket(bucketNameDel);
				Thread.sleep(1*1000);
				System.out.println("Suppression de " + bucketNameDel + " effectuée avec succès");
				Thread.sleep(1*1000);
				break;

			case 4:
				System.out.println("");
				System.out.println("ENVOYER UN OBJET SUR UN CONTENEUR S3");
				System.out.println("");
				System.out.println("Veuillez indiquer le nom du conteneur :");
				System.out.println("");
				String bucketNameUpObj = sc.nextLine();
				System.out.println("");
				AWSApplicationS3.uploadBucket(bucketNameUpObj);
				Thread.sleep(1*1000);
				System.out.println("Envoi effectué avec succès vers " + bucketNameUpObj);
				Thread.sleep(1*1000);
				break;
				
			case 5:
				System.out.println("");
				System.out.println("LISTER LES OBJETS D'UN CONTENEUR S3");
				System.out.println("");
				System.out.println("Veuillez indiquer le nom du conteneur :");
				System.out.println("");
				String bucketNameListObj = sc.nextLine();
				System.out.println("");
				System.out.println("");
				System.out.println("Liste des objets contenus dans " + bucketNameListObj + ":");
				System.out.println("");
				Thread.sleep(1*1000);
				AWSApplicationS3.listAllObjectsFromBucket(bucketNameListObj);
				Thread.sleep(3*1000);
				break;
				
			case 6:
				System.out.println("");
				System.out.println("TELECHARGER UN OBJET SUR UN CONTENEUR S3");
				System.out.println("");
				System.out.println("Veuillez indiquer le nom du conteneur :");
				System.out.println("");
				String bucketNameDlObj = sc.nextLine();
				System.out.println("");
				Thread.sleep(1*1000);
				try {
					AWSApplicationS3.downloadObjectFromBucket(bucketNameDlObj);
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("Téléchargement effectué avec succès");
				Thread.sleep(1*1000);
				break;
				
			case 7:
				System.out.println("");
				System.out.println("COPIER UN OBJET D'UN CONTENEUR S3");
				System.out.println("");
				System.out.println("Veuillez indiquer le nom du conteneur ou se trouve l'objet à copier :");
				System.out.println("");
				String bucketNameCpObj = sc.nextLine();
				System.out.println("");
				System.out.println("Veuillez indiquer le conteneur de destination où copier l'objet :");
				System.out.println("");
				String destinationBucketNameCpObj = sc.nextLine();
				System.out.println("");
				Thread.sleep(1*1000);
				AWSApplicationS3.copyObjectFromBucket(bucketNameCpObj, destinationBucketNameCpObj);
				System.out.println("Copie effectuée avec succès de " + bucketNameCpObj + " vers " + destinationBucketNameCpObj);
				Thread.sleep(1*1000);
				break;
				
			case 8:
				System.out.println("");
				System.out.println("SUPPRIMER UN OBJET D'UN CONTENEUR S3");
				System.out.println("");
				System.out.println("Veuillez indiquer le nom du conteneur :");
				System.out.println("");
				String bucketNameDelObj = sc.nextLine();
				System.out.println("");
				Thread.sleep(1*1000);
				AWSApplicationS3.deleteObjectFromBucket(bucketNameDelObj);
				System.out.println("L'objet a bien été supprimé avec succès du conteneur " + bucketNameDelObj);
				Thread.sleep(1*1000);
				break;
				
			case 9:
				System.out.println("");
				System.out.println("SUPPRIMER PLUSIEURS OBJETS D'UN CONTENEUR S3");
				System.out.println("");
				System.out.println("Veuillez indiquer le nom du conteneur :");
				System.out.println("");
				String bucketNameDelObjs = sc.nextLine();
				System.out.println("");
				Thread.sleep(1*1000);
				AWSApplicationS3.deleteObjectsFromBucket(bucketNameDelObjs);
				System.out.println("Les objets ont bien été supprimés avec succès du conteneur " + bucketNameDelObjs);
				Thread.sleep(1*1000);
				break;
				
			default:
				Thread.sleep(10*1000);
				System.out.println("");
				System.out.println("Choix inconnu, veuillez recommencer");
				System.out.println("");
				break;
			}
		}

		while (choixS3 != 0);
	}

}
