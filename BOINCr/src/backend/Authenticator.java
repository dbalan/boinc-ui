package backend;
import java.io.IOException;
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
	public int getRowsNos(ResultSet rs){
		int rows =0;
		try { 
		if (rs != null)   
		{  
	
		  rs.beforeFirst();  
		  rs.last();  
		  rows = rs.getRow();
		  rs.beforeFirst();
		}
		return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	public Object[][] getDataArray(String col,String table){
		try {
			Statement stmt = con.createStatement();
			  ResultSet rs;
			rs = stmt.executeQuery("SELECT "+col+" FROM "+table);
			int i=0;
			int colno=rs.getMetaData().getColumnCount();
			int rows =getRowsNos(rs);  
			Object result[][]=new Object[rows][colno];
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
	public ResultSet getResult(String col,String table){
		/*
		 * Does SELECT col FROM table.
		 * @see java.sql.ResultSet
		 * 
		 * @parm Column, table
		 * @return ResultSet
		 */
		try {
			Statement stmt = con.createStatement();
			  ResultSet rs;
			rs = stmt.executeQuery("SELECT "+col+" FROM "+table);
			return rs;
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
				return null;
			}
	}
	public boolean insert(String Feild,String Values,String Table){
		Statement stmt;
		try {
			
			stmt = con.createStatement();
			int row = stmt.executeUpdate("INSERT INTO "+Table+" ("+Feild+") VALUES ("+Values+")");
			if(row>0)return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		}
	public boolean insertRow(String Values,String Table){
	Statement stmt;
	try {
		
		stmt = con.createStatement();
		int row = stmt.executeUpdate("INSERT INTO "+Table+" VALUES ( "+Values+" )");
		if(row>0)return true;
		else return false;
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	
	}
	public Process execCommand(String command) throws IOException {
		Process p = null;
		
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
		}
		catch (InterruptedException ae)
		{
			System.err.println("E: Interrupt Execption.");
		}
		
		return p;
	}
	
	public boolean execSQL(String command){
		Statement stmt;
		try {
			
			stmt = con.createStatement();
			int row = stmt.executeUpdate(command);
			if(row>0)return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
