package aws;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class AWSApplicationS3 {

	private static String bucketName;
	private static final AWSCredentials credentials = new BasicAWSCredentials("ACCESS-KEY-AWS","SECRET-KEY-AWS");
//	AWSCredentials test = new AWSCredentials() {
//		
//		@Override
//		public String getAWSSecretKey() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//		
//		@Override
//		public String getAWSAccessKeyId() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//	};

	public static AmazonS3 connect() {
		AmazonS3 s3client = AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.EU_WEST_3).build();
		return s3client;
	}

	static AmazonS3 awsService = AWSApplicationS3.connect();

	// Creer un conteneur
	public static void createBucket(String bucketName) {
		try {
			if (awsService.doesBucketExistV2(bucketName)) {
				System.out.println("Le nom du conteneur est déjà pris." + " Veuillez réessayer avec un autre nom.");
				return;
			}
			awsService.createBucket(bucketName);
		}

		catch (Exception e) {
			System.err.println("GetItem failed.");
			System.err.println(e.getMessage());
		}
	}

	// Lister tous les conteneurs
	public static void listAllBuckets() {
		for (Bucket s : awsService.listBuckets()) {
			System.out.println(s.getName());
		}
	}

	// Supprimer un conteneur
	public static void deleteBucket(String bucketNameDel) {
		awsService.deleteBucket(bucketNameDel);
	}

	// Uploader un objet sur le conteneur
	public static void uploadBucket(String bucketNameUp) {
		awsService.putObject(bucketNameUp, "Tests\\test.pdf",
				new File("C:\\Users\\Megaport\\git\\CryptAndHash\\testsAWS\\test.pdf"));
	}

	// Lister les objets d'un conteneur
	public static void listAllObjectsFromBucket(String bucketName) {
		ObjectListing objectListing = awsService.listObjects(bucketName);
		for (S3ObjectSummary os : objectListing.getObjectSummaries()) {
			System.out.println(os.getKey());
		}
	}

	// Telecharger un objet d'un conteneur
	public static void downloadObjectFromBucket(String bucketName) throws IOException {
		S3Object s3object = awsService.getObject(bucketName, "Tests\\test.pdf");
		S3ObjectInputStream inputStream = s3object.getObjectContent();

		FileUtils.copyInputStreamToFile(inputStream,
				new File("C:\\Users\\Megaport\\git\\CryptAndHash\\testsAWS\\testDL.pdf"));
	}

	// Copier un objet d'un conteneur
	public static void copyObjectFromBucket(String bucketName, String destinationBucketName) {
		awsService.copyObject(bucketName, "Tests\\test.pdf", destinationBucketName, "TestCopy\\test.pdf");
	}

	// Supprimer un objet d'un conteneur
	public static void deleteObjectFromBucket(String bucketName) {
		awsService.deleteObject(bucketName, "Tests\\test.pdf");
	}

	// Supprimer plusieurs objets d'un conteneur
	public static void deleteObjectsFromBucket(String bucketName) {
		String objkeyArr[] = { "Tests\\test.pdf", "TestCopy\\test.pdf" };

		DeleteObjectsRequest delObjReq = new DeleteObjectsRequest(bucketName).withKeys(objkeyArr);
		awsService.deleteObjects(delObjReq);
	}

	public static String getBucketName() {
		return bucketName;
	}

	public static void setBucketName(String bucketName) {
		AWSApplicationS3.bucketName = bucketName;
	}

}
