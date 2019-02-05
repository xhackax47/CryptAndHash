/**
 * 
 * @author CHAABI Samy
 */

package app;

import org.apache.log4j.BasicConfigurator;

public class CryptAndHash {

	public static void main(String[] args) throws InterruptedException {		
		// Lancement programme
		CryptHash.start();
		BasicConfigurator.configure();
	}

}
