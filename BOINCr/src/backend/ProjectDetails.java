package backend;

import gui.Main;
import java.sql.*;
import java.io.*;

public class ProjectDetails {
	
	
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
		res.first();
		userNo = res.getInt(1);
		res = Main.Auth.getResult("COUNT(id)", "host");
		res.first();
		hostNo = res.getInt(1);
		res = Main.Auth.getResult("COUNT(id)", "workunit");
		res.first();
		workUnitNo = res.getInt(1);
		
		
		String projCmd = "grep PROJECT /var/tmp/boinc/docktest/html/project/project.inc";
		proc = Main.Auth.execCommand(projCmd);
		
		reader=new BufferedReader(new InputStreamReader(proc.getInputStream()));
		String tempName = reader.readLine();
		tempName = tempName.split(",")[1];
		tempName = tempName.split("\\)")[0];
		tempName = tempName.replaceAll("^\\s+", "");
		niceProjectName=tempName; 
		
		 
	}
	public String projecthtml(){
		String msg;
		msg="<html><p align=\"center\"><table>";
		msg+="<tr><td><b>Project Name</b></td><td>:</td><td>"+niceProjectName+"</td><tr>";
		msg+="<br><tr><td><b>Total Volunteers</b></td><td>:</td><td>"+Integer.toString(userNo)+"</td><tr>";
		msg+="<br><tr><td><b>Total Hosts</b></td><td>:</td><td>"+Integer.toString(hostNo)+"</td><tr>";
		msg+="<br><tr><td><b>Workunits Registred</b></td><td>:</td><td>"+Integer.toString(workUnitNo)+"</td><tr>";
		msg+="</table><p></html>";
		return msg;
		
	}

}
