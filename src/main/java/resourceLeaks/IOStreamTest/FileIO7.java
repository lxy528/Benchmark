package resourceLeaks.IOStreamTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO7 {
public static void main(String[] args) throws IOException {
	  FileOutputStream fos = 
    	      new FileOutputStream(new File("test.txt"));
    	int count =0;
	  if(count != 2){
  		fos.write(7);   
  	    fos.close();
  	}
    	
}
}
