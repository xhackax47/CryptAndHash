package menus;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Menus;

public class TestMenuC {

	@Test
	public void testMenuC() {
		
		assertEquals(0,Menus.getMenuC());
		
		// Une fois vérifié que la variable est bien égale à 0 au départ on appelle la methode.
		
		Menus.afficheMenuCryptage();
		
		// Nous testons les différents affichages de menus en vérifiant que la variable est bien passé de 0 à 1.
		
		assertEquals(1,Menus.getMenuC());
		
	}

}
