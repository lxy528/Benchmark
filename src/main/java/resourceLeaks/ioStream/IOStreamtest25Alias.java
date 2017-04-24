package resourceLeaks.ioStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOStreamtest25Alias {


	public void open() throws IOException {
		FileOutputStream f1 = new FileOutputStream(new File(""));
		FileOutputStream f2 = f1;
		FileOutputStream f3 = f2;
		FileOutputStream f4 = f3;
		FileOutputStream f5 = f4;
		FileOutputStream f6 = f5;
		FileOutputStream f7 = f6;
		FileOutputStream f8 = f7;
		FileOutputStream f9 = f8;
		FileOutputStream f10 = f9;
		close(f10);
	}
	public void close(FileOutputStream f1) throws IOException {
		FileOutputStream f2 = f1;
		FileOutputStream f3 = f2;
		FileOutputStream f4 = f3;
		FileOutputStream f5 = f4;
		FileOutputStream f6 = f5;
		FileOutputStream f7 = f6;
		FileOutputStream f8 = f7;
		FileOutputStream f9 = f8;
		FileOutputStream f10 = f9;
		f10.close();
	}
	
	
	
}
