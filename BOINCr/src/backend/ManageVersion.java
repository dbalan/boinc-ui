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
	String app_name;
	String condition;

	ArrayList<Integer> versionAvailable = new ArrayList<Integer>();

	public ManageVersion(String appId) throws SQLException {
		ResultSet res;
		this.appId=Integer.parseInt(appId);
		condition = "id="+appId;
		res = Main.Auth.getResult("name,min_version,weight","app", condition);
		res.first();
		app_name= res.getString("name");
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


	public int getCurrentMinVersion() throws SQLException
	{
		/*
		 * @return current app version.
		 */

		return min_ver;

	}
	public String getname()
	{
		/*
		 * @return app_name.
		 */

		return app_name;

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
