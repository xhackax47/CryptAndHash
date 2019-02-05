/**
 * 
 * @author CHAABI Samy
 */

package hash;

import static org.junit.Assert.*;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class TestSHA1 {

	@Test
	public void testSHA1() {

		String sha1String = "Test";
		String sha1HexExpected = "640ab2bae07bedc4c163f679a746f7ab7fb5d1fa";
		String sha1Hex = DigestUtils.sha1Hex(sha1String);
		
		assertEquals(sha1HexExpected, sha1Hex);
		
		if(sha1HexExpected.equals(sha1Hex)) {
			System.out.println("TEST SHA128 = OK !!!");
		}
	}

}
