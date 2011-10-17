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
				res = Main.Auth.getResult("id", "platform","name=\""+PlatformArray[i][0]+"\"");
				if(res.getInt(1) != 0 )		//Exception due to empty result set or before start of result 
				{							//try ----- if(res==null){....}else res.first();---- before	if(res.getInt(1) != 0 ){..	 
					res = Main.Auth.getResult("MAX (id)", "platform");
					int nextID = res.getInt(1)+1;
					
					
					String Values = Integer.toString(nextID)+","+Long.toString(epoch)+","+PlatformArray[i][0]+","+PlatformArray[1];
					Main.Auth.insert(Values, "platform");
				}
			}
			catch (Exception ae)
			{
				ae.printStackTrace();
				System.err.println("W: Constraint Violation, Possibly due to platform already present in database.");
			}

		}
		
		epoch = System.currentTimeMillis()/1000;
		System.err.println("I: Create Time "+ Long.toString(epoch));
		String AppValues = "NULL,'"+Long.toString(epoch)+"','"+appName+"','0','0','"+actualAppName+"','0','1','0','0','1','0'";
		boolean flag = Main.Auth.insert(AppValues, "app");

		if(flag)
		{
			System.err.println("I: App "+appName+" Added");
		}

	}

}

