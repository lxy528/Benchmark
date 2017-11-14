package resourceLeaks.IOStreamTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileIO14 implements FileIO13{

	@Override
	public void open(String a) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis= new FileInputStream(new File(a));
		close(fis);
	}

	@Override
	public void close(FileInputStream fis)throws IOException  {
		// TODO Auto-generated method stub
		fis.close();
	}
	public void main(String [] args)throws IOException{
		FileIO13 file = new FileIO14();
		file.open("1.txt");
		
	}

}
