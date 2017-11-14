package resourceLeaks.IOStreamTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileIO3{
	public static void foo () throws IOException {
	    FileInputStream fos = 
	    	      new FileInputStream(new File("test.txt"));
	    fos.read();
	    pass(fos);
	  }
	public static void pass(FileInputStream file) throws IOException{
		file.close();
	}
}
