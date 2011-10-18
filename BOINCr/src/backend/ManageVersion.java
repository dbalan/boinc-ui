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
	int appId;
	int appWeight=0;

	ArrayList<Integer> versionAvailable = new ArrayList<Integer>();

	public ManageVersion(String appId) throws SQLException {
		ResultSet res;
		this.appId=Integer.parseInt(appId);
		String condition = "id="+appId;
		res = Main.Auth.getResult("min_version,weight","app", condition);
		res.first();
		min_ver = res.getInt("min_version");
		appWeight = res.getInt("weight");

		condition = " appid="+appId;
		res = Main.Auth.getResult("MAX(version_num)","app_version",condition);//app
		res.first();
		max_ver = res.getInt(1);

		res = Main.Auth.getResult("version_num","app_version", condition);//app

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
