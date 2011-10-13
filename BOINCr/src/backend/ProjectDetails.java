package backend;

import gui.Main;
import java.sql.*;
import java.io.*;

public class ProjectDetails {
	
	String projectName;
	String niceProjectName; // User friendly project name;
	int userNo;  // Total Number of volunteers in system.
	int hostNo;  // Total no of hosts.
	int workUnitNo; // Number of workunits to compute.
	//TODO float FLOPS; // FLOPS of the computing system. 
	
	public ProjectDetails(String projectPath) throws SQLException, IOException {
		ResultSet res;
		Process proc;
		BufferedReader reader;
		
		res = Main.Auth.getResult("COUNT(id)", "user");
		userNo = res.getInt(1);
		res = Main.Auth.getResult("COUNT(id)", "host");
		hostNo = res.getInt(1);
		res = Main.Auth.getResult("COUNT(id)", "workunit");
		workUnitNo = res.getInt(1);
		
		
		String projCmd = "grep PROJECT "+projectPath+"/html/project/project.inc | head -n1 | cut -d , -f2 | cut -d \" -f2";
		proc = Main.Auth.execCommand(projCmd);
		
		reader=new BufferedReader(new InputStreamReader(proc.getInputStream()));
		
		
		niceProjectName=reader.readLine(); 
		
		 
	}
	public String projecthtml(){
		String msg;
		msg="<html><p align=\"center\"><table>";
		msg+="<tr><td>Project Name</td><td>:</td><td>"+projectName+"</td><tr>";
		msg+="<tr><td>Nice Project Name</td><td>:</td><td>"+niceProjectName+"</td><tr>";
		msg+="<tr><td>User No</td><td>:</td><td>"+Integer.toString(userNo)+"</td><tr>";
		msg+="<tr><td>Host No</td><td>:</td><td>"+Integer.toString(hostNo)+"</td><tr>";
		msg+="<tr><td>Work Uint No</td><td>:</td><td>"+Integer.toString(workUnitNo)+"</td><tr>";
		msg+="<tr><td>User No</td><td>:</td><td>"+Integer.toString(userNo)+"</td><tr>";
		msg+="</table><p></html>";
		return msg;
		
	}

}
