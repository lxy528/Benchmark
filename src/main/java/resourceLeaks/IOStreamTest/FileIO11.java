package resourceLeaks.IOStreamTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileIO11 {
	public void open(String a) throws IOException{
		 FileInputStream fis =  new FileInputStream(new File(a));
		 close(fis);
	}
	public void close( FileInputStream fis) throws IOException{
		fis.close();
	}
//	public void main(String[] args) throws IOException{
//		String filename="1.txt";
//		
//		close(open(filename));
//	}
}
