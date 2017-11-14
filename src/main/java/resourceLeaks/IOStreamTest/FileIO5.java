package resourceLeaks.IOStreamTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO5 {
	public static void pass(FileInputStream fs) throws IOException {
		fs.read();
		//fs.close();
		
	}
	public static void pass(FileOutputStream fs) throws IOException {
		fs.write(7);
	//	fs.close();
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		  FileInputStream fis = new FileInputStream(new File("1.txt"));
		  fis.read();
		  pass(fis);
	}
}
