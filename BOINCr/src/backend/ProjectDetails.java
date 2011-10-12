package backend;

import gui.Main;
import java.sql.*;

public class ProjectDetails {
	
	String projectName;
	String niceProjectName; // User friendly project name;
	int userNo;  // Total Number of volunteers in system.
	int hostNo;  // Total no of hosts.
	int workUnitNo; // Number of workunits to compute.
	float FLOPS; // FLOPS of the computing system. 
	
	public ProjectDetails(String projectPath) throws SQLException {
		ResultSet res;
		res = Main.Auth.getResult("COUNT(id)", "user");
		userNo = res.getInt(1);
	}

}
