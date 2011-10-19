package gui;

import backend.Authenticator;
import backend.Log;

public class Main {
	public static  Authenticator Auth; 
	static Window Win;
	public static Log log;
	public Main() {
		Auth=new Authenticator();
		log=new Log("boinc.log");
		Win=new Window();

		}
	protected void finalize(){
		Auth.exit();
		
	}
}
