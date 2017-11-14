package resourceLeaks.IOStreamTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO6 {
	public void main(String[] args) throws IOException {
		FileOutputStream fos = 
		  	      new FileOutputStream(new File("test.txt"));
		  	    fos.write(7); 
		 FileIO5.pass(fos);
	}
  	    
}
