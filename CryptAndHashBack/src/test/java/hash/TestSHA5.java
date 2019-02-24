/**
 * 
 * @author CHAABI Samy
 */

package hash;

import static org.junit.Assert.*;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class TestSHA5 {

	@Test
	public void test() {

		String sha5String = "Test";
		String sha5HexExpected = "c6ee9e33cf5c6715a1d148fd73f7318884b41adcb916021e2bc0e800a5c5dd97f5142178f6ae88c8fdd98e1afb0ce4c8d2c54b5f37b30b7da1997bb33b0b8a31";
		String sha5Hex = DigestUtils.sha512Hex(sha5String);
		
		assertEquals(sha5HexExpected, sha5Hex);
		
		if(sha5HexExpected.equals(sha5Hex)) {
			System.out.println("TEST SHA512 = OK !!!");
		}
	}

}
