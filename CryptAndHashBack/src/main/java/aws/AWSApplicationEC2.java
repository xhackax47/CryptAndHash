/**
 * 
 * @author CHAABI Samy
 */

package aws;

import java.util.Arrays;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.AuthorizeSecurityGroupIngressRequest;
import com.amazonaws.services.ec2.model.CreateKeyPairRequest;
import com.amazonaws.services.ec2.model.CreateKeyPairResult;
import com.amazonaws.services.ec2.model.CreateSecurityGroupRequest;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.DescribeKeyPairsRequest;
import com.amazonaws.services.ec2.model.DescribeKeyPairsResult;
import com.amazonaws.services.ec2.model.IpPermission;
import com.amazonaws.services.ec2.model.IpRange;
import com.amazonaws.services.ec2.model.MonitorInstancesRequest;
import com.amazonaws.services.ec2.model.RebootInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.StartInstancesRequest;
import com.amazonaws.services.ec2.model.StopInstancesRequest;
import com.amazonaws.services.ec2.model.UnmonitorInstancesRequest;

public class AWSApplicationEC2 {

	private static String instanceID;
	private static final AWSCredentials credentials = new BasicAWSCredentials("ACCESS-KEY-AWS", "SECRET-KEY-AWS");

//	AWSCredentials test = new AWSCredentials() {
//	
//	@Override
//	public String getAWSSecretKey() {
//		return null;
//	}
//	
//	@Override
//	public String getAWSAccessKeyId() {
//		return null;
//	}
//};

	public static AmazonEC2 connectEC2() {
		AmazonEC2 ec2Client = AmazonEC2ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.EU_WEST_3).build();
		return ec2Client;
	}


	// Créer un groupe de sécurité
	public static void createSecurityGroup() {

		CreateSecurityGroupRequest createSecurityGroupRequest = new CreateSecurityGroupRequest()
				.withGroupName("CryptAndHashSecurityGroup").withDescription("CryptAndHash Security Group");
		connectEC2().createSecurityGroup(createSecurityGroupRequest);

		// Autoriser le traffic HTTP et SSH
		IpRange ipRange1 = new IpRange().withCidrIp("0.0.0.0/0");

		IpPermission ipPermission1 = new IpPermission().withIpv4Ranges(Arrays.asList(new IpRange[] { ipRange1 }))
				.withIpProtocol("tcp").withFromPort(80).withToPort(80);

		IpPermission ipPermission2 = new IpPermission().withIpv4Ranges(Arrays.asList(new IpRange[] { ipRange1 }))
				.withIpProtocol("tcp").withFromPort(22).withToPort(22);

		AuthorizeSecurityGroupIngressRequest authorizeSecurityGroupIngressRequest = new AuthorizeSecurityGroupIngressRequest()
				.withGroupName("CryptAndHashSecurityGroup").withIpPermissions(ipPermission1, ipPermission2);

		connectEC2().authorizeSecurityGroupIngress(authorizeSecurityGroupIngressRequest);

	}

	public static void createKeyPair() {
		CreateKeyPairRequest createKeyPairRequest = new CreateKeyPairRequest().withKeyName("cryptandhash-key-pair");
		CreateKeyPairResult createKeyPairResult = connectEC2().createKeyPair(createKeyPairRequest);
		String privateKey = createKeyPairResult.getKeyPair().getKeyMaterial(); // make sure you keep it, the private
																				// key, Amazon doesn't store the private
																				// key
	}

	public static void getKeyPairs() {
		DescribeKeyPairsRequest describeKeyPairsRequest = new DescribeKeyPairsRequest();
		DescribeKeyPairsResult describeKeyPairsResult = connectEC2().describeKeyPairs(describeKeyPairsRequest);
	}

	// Lancer une instance EC2 AWS
	public static void launchEC2Instance() {
		RunInstancesRequest runInstancesRequest = new RunInstancesRequest().withImageId("ami-97785bed") // https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/AMIs.html
																										// |
																										// https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/usingsharedamis-finding.html
				.withInstanceType("t2.micro") // https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/instance-types.html
				.withMinCount(1).withMaxCount(1).withKeyName("cryptandhash-key-pair") // optional - if not present, can't
																					// connect to instance
				.withSecurityGroups("CryptAndHashSecurityGroup");

		instanceID = connectEC2().runInstances(runInstancesRequest).getReservation().getInstances().get(0)
				.getInstanceId();
	}

	// Démarrer une instance EC2 AWS
	public static void startEC2Instance() {
		StartInstancesRequest startInstancesRequest = new StartInstancesRequest().withInstanceIds(instanceID);

		connectEC2().startInstances(startInstancesRequest);
	}

	// Surveiller une instance EC2 AWS
	public static void monitorEC2Instance() {
		MonitorInstancesRequest monitorInstancesRequest = new MonitorInstancesRequest().withInstanceIds(instanceID);

		connectEC2().monitorInstances(monitorInstancesRequest);
	}

	// Ne plus surveiller une instance EC2 AWS
	public static void unMonitorEC2Instance() {
		UnmonitorInstancesRequest unmonitorInstancesRequest = new UnmonitorInstancesRequest()
				.withInstanceIds(instanceID);

		connectEC2().unmonitorInstances(unmonitorInstancesRequest);
	}

	// Redemarrer une instance EC2 AWS
	public static void rebootEC2Instance() {
		RebootInstancesRequest rebootInstancesRequest = new RebootInstancesRequest().withInstanceIds(instanceID);

		connectEC2().rebootInstances(rebootInstancesRequest);
	}

	// Arreter une instance EC2 AWS
	public static void stopEC2Instance() {
		StopInstancesRequest stopInstancesRequest = new StopInstancesRequest().withInstanceIds(instanceID);

		connectEC2().stopInstances(stopInstancesRequest).getStoppingInstances().get(0).getPreviousState().getName();
	}

	// Description de l'instance EC2 AWS
	public static void describeEC2Instance() {
		DescribeInstancesRequest describeInstancesRequest = new DescribeInstancesRequest();
		DescribeInstancesResult response = connectEC2().describeInstances(describeInstancesRequest);
		System.out.println(response.getReservations().get(0).getInstances().get(0).getKernelId());
	}

}