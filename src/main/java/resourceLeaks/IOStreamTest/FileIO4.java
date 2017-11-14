package resourceLeaks.IOStreamTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileIO4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		  FileInputStream fis = new FileInputStream(new File("1.txt"));
		  fis.read();
		  //FileIO5.pass(fis);
	}

}
