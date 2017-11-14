package resourceLeaks.ioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOStreamtest1 {
	public static FileInputStream fis;
	public static void foo() throws IOException  {
		int x = 0;
	    FileOutputStream fos = null;
	    try {
	    	
//	        fis = new FileInputStream(new File("1.txt"));
			fos = new FileOutputStream(new File("2.txt"));
	        fos.write(fis.read());
	      } 
	    finally {
		    if (fos!=null)
		    {
		    	fos.close();
		    	fos = null;
		    }
	    }
	  }
}
