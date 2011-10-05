package gui;

import backend.Authenticator;

public class Main {
	static  Authenticator A; 
	static Window win;
	
	public Main() {
		A=new Authenticator();
		win=new Window();

		}
	protected void finalize(){
		A.exit();
		
	}
}
