package resourceLeaks.IOStreamTest;

import java.io.FileInputStream;
import java.io.IOException;

public class FileIO12 extends FileIO11{
	
	public  void close( FileInputStream fis) throws IOException{
		System.out.println("file not close");
	}
	public void main(String [] args) throws IOException{
		FileIO11 file= new FileIO12();
		file.open("E:\\project\\huawei-sa\\bench\\Defects-benchmark\\findbugstest\\src\\resourceleaks\\1.txt");
	}
}