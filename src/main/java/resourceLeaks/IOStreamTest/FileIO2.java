package resourceLeaks.IOStreamTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public static void foo () throws IOException {
	    FileOutputStream fos = 
	    	      new FileOutputStream(new File("test.txt"));
	    	    fos.write(7);   
	    	    fos.close();
	  }
}
