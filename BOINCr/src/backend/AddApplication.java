package backend;

/*
 * Backend for adding app and platforms into boinc database
 */

import gui.Main;

import java.sql.*;

public class AddApplication {


	public AddApplication(int Platform[], String appName, String actualAppName) throws SQLException {
		// Check platforms and Add.
		String PlatformArray[][] = new String[2][];
        long epoch = 0;
        
		for (int i=0; i < 2; i++)
		{
			PlatformArray[i] = new String[2];
		}

		PlatformArray[0][0] = "windows_intelx86";
		PlatformArray[0][1] = "Microsoft Windows (98 or later) running on an Intel x86-compatible CPU";
		PlatformArray[1][0] = "i686-pc-linux-gnu";
		PlatformArray[1][1] = "Linux running on an Intel x86-compatible CPU";
		//TODO Add platforms as nec.

		for (int i=0 ; i < 2; i++)
		{
			try
			{	
				ResultSet res;
				res = Main.Auth.getResult("id", "platform WHERE name="+PlatformArray[1]);
				if(res.getInt(1) != 0 )
				{
					res = Main.Auth.getResult("MAX (id)", "platform");
					int nextID = res.getInt(1)+1;
					epoch = System.currentTimeMillis()/1000;
					
					String Values = Integer.toString(nextID)+","+Long.toString(epoch)+","+PlatformArray[i][0]+","+PlatformArray[1];
					Main.Auth.insertRow(Values, "platform");
				}
			}
			catch (Exception ae)
			{
				System.err.println("E: Constraint Violation");
			}

		}

		String AppValues = "1,"+Long.toString(epoch)+","+appName+",0,0,"+actualAppName+",0,1,0,0,1,0";
		boolean flag = Main.Auth.insertRow(AppValues, "app");

		if(flag)
		{
			System.err.println("I: App "+appName+" Added");
		}

	}

}

