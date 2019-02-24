/**
 * 
 * @author CHAABI Samy
 */

package menus;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Menus;

public class TestMenuG {

	@Test
	public void testMenuG() {
		
		assertEquals(false,Menus.isMenuG());
		
		// Une fois vérifié que la variable est bien égale à 0 au départ on appelle la methode.
		
		Menus.menuGeneral();
		
		// Nous testons les différents affichages de menus en vérifiant que la variable est bien passé de 0 à 1.
		
		assertEquals(true,Menus.isMenuG());
		
	}

}
