/**
 * 
 * @author CHAABI Samy
 */

package hash;

import static org.junit.Assert.*;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class TestMD5 {

	@Test
	public void testMD5() {
		
		String md5String = "Test";
		String md5HexExpected = "0cbc6611f5540bd0809a388dc95a615b";
		String md5Hex = DigestUtils.md5Hex(md5String);
		
		assertEquals(md5HexExpected, md5Hex);
		
		if(md5HexExpected.equals(md5Hex)) {
			System.out.println("TEST MD5 = OK !!!");
		}
	}

}
