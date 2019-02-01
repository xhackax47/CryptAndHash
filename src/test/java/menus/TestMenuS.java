package menus;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Menus;

public class TestMenuS {

	@Test
	public void testMenuS() {
		
		assertEquals(0,Menus.getMenuS());
		
		// Une fois vérifié que la variable est bien égale à 0 au départ on appelle la methode.

		Menus.afficheMenuSecret();
		
		// Nous testons les différents affichages de menus en vérifiant que la variable est bien passé de 0 à 1.

		assertEquals(1,Menus.getMenuS());
		
	}

}
