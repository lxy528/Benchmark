package resourceLeaks.IOStreamTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO {
	public static void foo() throws IOException {
		 FileInputStream  fis =null;
	    FileOutputStream fos = null;
	    try {
	    	   fis = new FileInputStream(new File("1.txt"));
	        fos = new FileOutputStream(new File("2.txt"));
	        fos.write(fis.read());
	      } 
	    finally {
//	        try {
//	        	if (fis!=null)  fis.close();
//			} catch (Exception e) {
//				// TODO: handle exception
//			}finally {
//				 if (fos!=null) fos.close();
//			}
//	       
	    	if (fis!=null)  fis.close();
		    if (fos!=null) fos.close();
	      }
	  }
}
