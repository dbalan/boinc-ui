package gui;

import backend.Authenticator;

public class Main {
	static  Authenticator A; 
	static Window win;
	
	public static void main(String[] args) {
		A=new Authenticator();
		win=new Window();

		}
	protected void finalize(){
		A.exit();
		
	}
}
