package backend;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Log {
	public Logger logger;
	public Log(String file){
		try {
		    // Create a file handler that write log record to a file called my.log
		    FileHandler handler = new FileHandler(file,true);
	    // Add to the desired logger com.mycompany is default
		    logger = Logger.getAnonymousLogger();
		    logger.addHandler(handler);
		} catch (IOException e) {
			
		}
	}

}
