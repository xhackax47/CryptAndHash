package menus;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Menus;

public class TestMenuAWSEC2 {

	@Test
	public void testMenuEC2() {
		
		assertEquals(false,Menus.isMenuAWSEC2());
		
		// Une fois vérifié que la variable est bien égale à 0 au départ on appelle la methode.
		
		Menus.afficheMenuAWSEC2();
		
		// Nous testons les différents affichages de menus en vérifiant que la variable est bien passé de 0 à 1.
		
		assertEquals(true,Menus.isMenuAWSEC2());
		
	}

}
