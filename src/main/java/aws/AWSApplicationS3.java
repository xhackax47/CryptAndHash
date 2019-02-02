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

	private static String bucketName = null;
	private static final AWSCredentials credentials = new BasicAWSCredentials("<AWS accesskey>", "<AWS secretkey>");

	public static AWSServiceS3 connect() throws IOException {
		AmazonS3 s3client = AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.EU_WEST_3).build();
		return (AWSServiceS3) s3client;
	}
	
	public static void awsS3() throws IOException {
		
        AWSServiceS3 awsService = AWSApplicationS3.connect();

        bucketName = "cryptandhash-bucket";

        //creating a bucket
        if(awsService.doesBucketExist(bucketName)) {
            System.out.println("Le nom du conteneur n'est pas valide."
              + " Veuillez réessayer avec un autre nom.");
            return;
        }
        awsService.createBucket(bucketName);
        
        //list all the buckets
        for(Bucket s : awsService.listBuckets() ) {
            System.out.println(s.getName());
        }
        
        //deleting bucket
        awsService.deleteBucket("cryptandhash-bucket-test2");
        
        //uploading object
        awsService.putObject(
          bucketName, 
          "Document/hello.txt",
          new File("/Users/user/Document/hello.txt")
        );

        //listing objects
        ObjectListing objectListing = awsService.listObjects(bucketName);
        for(S3ObjectSummary os : objectListing.getObjectSummaries()) {
            System.out.println(os.getKey());
        }

        //downloading an object
        S3Object s3object = awsService.getObject(bucketName, "Document/hello.txt");
        S3ObjectInputStream inputStream = s3object.getObjectContent();
        FileUtils.copyInputStreamToFile(inputStream, new File("/Users/user/Desktop/hello.txt"));
        
        //copying an object
        awsService.copyObject(
          "cryptandhash-bucket", 
          "picture/pic.png", 
          "cryptandhash-bucket2", 
          "Document/picture.png"
        );
        
        //deleting an object
        awsService.deleteObject(bucketName, "Document/hello.txt");

        //deleting multiple objects
        String objkeyArr[] = {
          "Document/hello2.txt", 
          "Document/picture.png"
        };
        
        DeleteObjectsRequest delObjReq = new DeleteObjectsRequest("cryptandhash-bucket")
          .withKeys(objkeyArr);
        awsService.deleteObjects(delObjReq);
    }

}
