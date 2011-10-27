package backend;
import gui.Main;

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
			System.err.println(cString);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(cString, username, password);
			//System.err.println("Established Connection to "+ con.getMetaData().getURL());
			Main.log.logger.info("Established Connection to "+ con.getMetaData().getURL());
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
			//System.err.println("Disconneted from "+str);
			Main.log.logger.info("Disconneted from "+str);
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
	public Object[][] getDataArray(String col,String table,String condition){
		try {
			Statement stmt = con.createStatement();
			  ResultSet rs;
			rs = stmt.executeQuery("SELECT "+col+" FROM "+table+" WHERE "+condition);
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
	
	public Object[][] getDataArray(String col,String table){
		return getDataArray(col,table,"True");
	}
	

	public ResultSet getResult(String col,String table,String condition){
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
			  System.err.println("SELECT "+col+" FROM "+table+" WHERE "+condition);
			rs = stmt.executeQuery("SELECT "+col+" FROM "+table+" WHERE "+condition);
			return rs;
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
				return null;
			}
	}
	public ResultSet getResult(String col,String table){
		return getResult(col,table,"True");
	}
	public boolean insert(String Feild,String Values,String Table){
		Statement stmt;
		if(Feild.isEmpty()){
			Feild=" ("+Feild+" )";
		}
		try {
			
			stmt = con.createStatement();
			int row = stmt.executeUpdate("INSERT INTO "+Table+Feild+" VALUES ("+Values+")");
			if(row>0)return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		}
	public boolean insert(String Values,String Table){
		return insert("",Values,Table);
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
			boolean row = stmt.execute(command);
			return row;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	/*
	 * call update as
	 * update(Feild,new_value,table,"");
	 * for update whole table
	 */
	public boolean update(String Feild,String new_value,String table,String condition){
		if(condition.isEmpty()){
			condition="True";
		}
		String stmt="UPDATE "+table+" SET "+Feild+"="+new_value+" WHERE "+condition;
		return execSQL(stmt);
		
	}
	protected void finalize(){
		exit();		
	}
	public boolean delete(String table,String condition){
		Statement stmt;
		String sql = "DELETE FROM "+table+" WHERE "+condition;
		try {
			stmt = con.createStatement();
			int rows=stmt.executeUpdate(sql);
			if(rows>0) return true;
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
}
