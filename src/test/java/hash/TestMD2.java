/**
 * 
 * @author CHAABI Samy
 */

package hash;

import static org.junit.Assert.*;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class TestMD2 {

	@Test
	public void testMD2() {
		
		String md2String = "Test";
		String md2HexExpected = "1178f3ddf625018179a93c1a0298dfa9";
		String md2Hex = DigestUtils.md2Hex(md2String);
		
		assertEquals(md2HexExpected, md2Hex);
		
		if(md2HexExpected.equals(md2Hex)) {
			System.out.println("TEST MD2 = OK !!!");
		}
		
	}

}
