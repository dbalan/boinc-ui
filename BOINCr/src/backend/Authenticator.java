package backend;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Authenticator {
	Connection con;
	public boolean getConnected(String username, String password, String server, String database)
	{
		//Class driverClass = null;
		try
		{
			String cString="jdbc:mysql://"+server+"/"+database;
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(cString, username, password);
			System.err.println("Established Connection to "+ con.getMetaData().getURL());
			return true;
		}

		catch (ClassNotFoundException ae)
		{
			System.err.println("Class Not Found!!!");
			ae.printStackTrace();
			return false;
		}		
		catch (SQLException sqle)
		{
			System.err.println("SQLException!!");
			sqle.printStackTrace();
			return false;
		}
	}
	public void exit()
	{
		try {
			String str=con.getMetaData().getURL();
			con.close();
			System.err.println("Disconneted from "+str);
		} catch (SQLException e) {
			System.err.println("SQLException!!");
			e.printStackTrace();
		}
	}
	public Object[][] getdataarray(String col,String table){
		try {
			Statement stmt = con.createStatement();
			  ResultSet rs;
			rs = stmt.executeQuery("SELECT "+col+" FROM "+table);
			int i=0;
			int colno=rs.getMetaData().getColumnCount();
			int rows =0;  
			if (rs != null)   
			{  
			  rs.beforeFirst();  
			  rs.last();  
			  rows = rs.getRow();  
			}
			Object result[][]=new Object[rows][colno];
			rs.beforeFirst();
			//System.out.println(rows +"  "+colno);
			while(rs.next()){
				for(int j=0;j<colno;j++){
					result [i][j]=rs.getObject(j+1);
					
				}
				i++;
			}
			return result;
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
				return null;
			}
	}
}
