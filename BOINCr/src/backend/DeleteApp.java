package backend;
import gui.Main;

public class DeleteApp {
	static public boolean deleteApp(String app_id){
		try {
			boolean flag1 = Main.Auth.delete("app","id="+app_id);
			boolean flag2 = Main.Auth.delete("app_version","appid="+app_id);
			System.err.println(flag2);
			System.err.println(flag2);
			
			return flag1 && flag2;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
