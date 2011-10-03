package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Authenticator {
	Connection con;
	public void getConnected(String username, String password, String server, String database)
	{
		Class driverClass = null;
		

		try
		{
			String cString="jdbc:mysql://"+server+"/"+database;
			driverClass.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(cString, username, password);
			System.err.println("Established Connection to "+ con.getMetaData().getURL());
		}

		catch (ClassNotFoundException ae)
		{
			System.err.println("Class Not Found!!!");
			ae.printStackTrace();
			return;
		}		
		catch (SQLException sqle)
		{
			System.err.println("SQLException!!");
			sqle.printStackTrace();
		}
	}

}
