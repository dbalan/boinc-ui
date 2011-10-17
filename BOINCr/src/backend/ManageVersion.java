package backend;

/*
 * Class to manage the app version numbers.
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gui.Main;

public class ManageVersion {

	int max_ver=0;
	int min_ver=0;
	int appId=0;
	int appWeight=0;

	ArrayList<Integer> versionAvailable = new ArrayList<Integer>();

	public ManageVersion(String app) throws SQLException {
		ResultSet res=null;

		String condition = "name="+app;
		res = Main.Auth.getResult("id,min_version,weight","app", condition);
		appId = res.getInt("id");
		min_ver = res.getInt("min_version");
		appWeight = res.getInt("weight");

		condition = "app_version WHERE appid="+appId;
		res = Main.Auth.getResult("MAX(version_num)","app",condition);

		max_ver = res.getInt(1);

		res = Main.Auth.getResult("version_num","app", condition);

		while(res.next())
		{
			versionAvailable.add(res.getInt("version_num"));
		}


	}


	public int getCurrentVersion()
	{
		/*
		 * @return current app version.
		 */

		return max_ver;

	}

	public ArrayList<Integer> getAvailableVersion()
	{
		return versionAvailable;
	}

	public boolean changeMinVersion(int newVersion)
	{
		String command="UPDATE app set min_version="+newVersion+" where id="+appId;
		boolean flag=Main.Auth.execSQL(command);

		return flag;

	}
	public int getCurrentWeight()
	{
		return appWeight;
	}
	public boolean changeWeight(int newWeight)
	{
		String command="UPDATE app set weight="+newWeight+" where id="+appId;
		boolean flag=Main.Auth.execSQL(command);

		return flag;

	}

}
