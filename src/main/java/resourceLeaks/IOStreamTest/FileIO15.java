package resourceLeaks.IOStreamTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileIO15 implements FileIO13{

	@Override
	public void open(String a) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis= new FileInputStream(new File(a));
		close(fis);
	}

	@Override
	public void close(FileInputStream fis) throws IOException {
		// TODO Auto-generated method stub
		
	}
	public void main(String [] args)throws IOException{
		FileIO13 file = new FileIO15();
		file.open("1.txt");
		
	}
}
