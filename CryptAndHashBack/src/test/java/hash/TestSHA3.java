/**
 * 
 * @author CHAABI Samy
 */

package hash;

import static org.junit.Assert.*;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class TestSHA3 {

	@Test
	public void testSHA3() {

		String sha3String = "Test";
		String sha3HexExpected = "7b8f4654076b80eb963911f19cfad1aaf4285ed48e826f6cde1b01a79aa73fadb5446e667fc4f90417782c91270540f3";
		String sha3Hex = DigestUtils.sha384Hex(sha3String);
		
		assertEquals(sha3HexExpected, sha3Hex);
		
		if(sha3HexExpected.equals(sha3Hex)) {
			System.out.println("TEST SHA384 = OK !!!");
		}
	}

}
