/**
 * 
 * @author CHAABI Samy
 */

package menus;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Menus;

public class TestMenuAWSS3 {

	@Test
	public void testMenuS3() {
		
		assertEquals(false,Menus.isMenuAWSS3());
		
		// Une fois vérifié que la variable est bien égale à 0 au départ on appelle la methode.
		
		Menus.menuAWSS3();
		
		// Nous testons les différents affichages de menus en vérifiant que la variable est bien passé de 0 à 1.
		
		assertEquals(true,Menus.isMenuAWSS3());
		
	}

}
