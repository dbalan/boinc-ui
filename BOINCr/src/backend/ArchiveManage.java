package backend;

/*
 * Extracts a zip archive
 * code adapted from
 * http://java.sun.com/developer/technicalArticles/Programming/compression/
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.zip.*;

public class ArchiveManage {
	
	private static final int BUFFER = 2048;
	String extractPath;
	String archivePath;
	
	public ArchiveManage(String projectPath, String appArchive) {
		extractPath=projectPath+File.separator+"apps";
		archivePath=appArchive;
	}
	
	public boolean ExtractArchive() {
		try {
	         BufferedOutputStream dest = null;
	         BufferedInputStream is = null;
	         ZipEntry entry;
	         ZipFile zipfile = new ZipFile(archivePath);
	         Enumeration e = zipfile.entries();
	         while(e.hasMoreElements()) {
	            entry = (ZipEntry) e.nextElement();
	            
	            // Make parent directory.
	            String name = entry.getName();
	            int i = name.lastIndexOf(File.separator);
	            String name2 = (i > -1) ? name.substring(0, i) : name;
	            
	            File temp = new File(name2);
	            temp.mkdirs();
	            
	            is = new BufferedInputStream
	              (zipfile.getInputStream(entry));
	            int count;
	            byte data[] = new byte[BUFFER];
	            
	            // Destination.
	            
	            FileOutputStream fos = new 
	              FileOutputStream(extractPath+File.separator+entry.getName());
	            dest = new 
	              BufferedOutputStream(fos, BUFFER);
	            while ((count = is.read(data, 0, BUFFER)) 
	              != -1) {
	               dest.write(data, 0, count);
	            }
	            dest.flush();
	            dest.close();
	            is.close();
	            
	         }
	         return true;
	      } catch(Exception e) {
	         e.printStackTrace();
	         return false;
	      }
	}
	
	public boolean SignArchive(String keyFilePath) {
		return true;
		/*
		 * TODO:Sign the files
		 */
	
	}

}
