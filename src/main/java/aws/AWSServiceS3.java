package aws;

import java.io.File;
import java.util.List;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CopyObjectResult;
import com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazonaws.services.s3.model.DeleteObjectsResult;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;

public class AWSServiceS3 {
	private final AmazonS3 s3client;

	public AWSServiceS3() {
		this(new AmazonS3Client(){});
	}

	public AWSServiceS3(AmazonS3 s3client) {
		this.s3client = s3client;
	}

	// Existence du conteneur
	public boolean doesBucketExist(String bucketName) {
		return s3client.doesBucketExist(bucketName);
	}

	// Creation conteneur
	public Bucket createBucket(String bucketName) {
		return s3client.createBucket(bucketName);
	}

	// Lister conteneurs
	public List<Bucket> listBuckets() {
		return s3client.listBuckets();
	}

	// Supprimer conteneur
	public void deleteBucket(String bucketName) {
		s3client.deleteBucket(bucketName);
	}

	// Upload objet vers conteneur
	public PutObjectResult putObject(String bucketName, String key, File file) {
		return s3client.putObject(bucketName, key, file);
	}

	// Lister objets d'un conteneur
	public ObjectListing listObjects(String bucketName) {
		return s3client.listObjects(bucketName);
	}

	// Recupérer un objet d'un conteneur
	public S3Object getObject(String bucketName, String objectKey) {
		return s3client.getObject(bucketName, objectKey);
	}

	// Copier un objet d'un conteneur
	public CopyObjectResult copyObject(String sourceBucketName, String sourceKey, String destinationBucketName,
			String destinationKey) {
		return s3client.copyObject(sourceBucketName, sourceKey, destinationBucketName, destinationKey);
	}

	// Supprimer un objet d'un conteneur
	public void deleteObject(String bucketName, String objectKey) {
		s3client.deleteObject(bucketName, objectKey);
	}

	// Supprimer plusieurs objets d'un conteneur
	public DeleteObjectsResult deleteObjects(DeleteObjectsRequest delObjReq) {
		return s3client.deleteObjects(delObjReq);
	}
}
