package backend;
/**
 * @author abilng
 *
 */
import java.sql.SQLException;
import gui.Main;

@SuppressWarnings("unused")
public class DeleteApp {
	static public boolean delete(int app_id){
		try {
			/*
			 * delete app from db
			 *  
			 * 
			 */
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
