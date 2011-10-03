/**
 * 
 */

/**
 * @author dhananjay
 *
 */

import backend.*;

public class Boincr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Authenticator authn = new Authenticator();
		authn.getConnected("test", "pass","localhost:3306", "jtest");
		
		
		

	}

}
