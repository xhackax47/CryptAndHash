/**
 * 
 * @author CHAABI Samy
 */

package hash;

import static org.junit.Assert.*;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class TestSHA2 {

	@Test
	public void testSHA2() {

		String sha2String = "Test";
		String sha2HexExpected = "532eaabd9574880dbf76b9b8cc00832c20a6ec113d682299550d7a6e0f345e25";
		String sha2Hex = DigestUtils.sha256Hex(sha2String);
		
		assertEquals(sha2HexExpected, sha2Hex);
		
		if(sha2HexExpected.equals(sha2Hex)) {
			System.out.println("TEST SHA256 = OK !!!");
		}
	}

}
