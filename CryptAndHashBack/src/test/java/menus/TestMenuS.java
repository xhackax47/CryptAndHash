/**
 * 
 * @author CHAABI Samy
 */

package menus;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Menus;

public class TestMenuS {

	@Test
	public void testMenuS() {
		
		assertEquals(false,Menus.isMenuS());
		
		// Une fois vérifié que la variable est bien égale à 0 au départ on appelle la methode.

		Menus.menuAES();
		
		// Nous testons les différents affichages de menus en vérifiant que la variable est bien passé de 0 à 1.

		assertEquals(true,Menus.isMenuS());
		
	}

}
