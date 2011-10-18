package backend;
import gui.Main;

public class DeleteApp {
	static public boolean deleteApp(int app_id){
		try {
			String app_ver_update="DELETE FROM app_version WHERE appid="+Integer.toString(app_id);
			String app_update="DELETE FROM app WHERE id="+Integer.toString(app_id);
			System.err.println(app_ver_update);
			boolean flag1 = Main.Auth.execSQL(app_ver_update);
			boolean flag2 = Main.Auth.execSQL(app_update);
			
			return flag1 && flag2;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
