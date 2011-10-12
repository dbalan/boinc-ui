package gui;

import backend.Authenticator;

public class Main {
	static  Authenticator Auth; 
	static Window Win;
	
	public Main() {
		Auth=new Authenticator();
		Win=new Window();

		}
	protected void finalize(){
		Auth.exit();
		
	}
}
