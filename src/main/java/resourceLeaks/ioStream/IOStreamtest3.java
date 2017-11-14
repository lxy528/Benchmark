package resourceLeaks.ioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class IOStreamtest3 {
	private FileInputStream fis;

	public FileInputStream getFis() throws IOException {
		fis= new FileInputStream (new File("1.txt"));
		return fis;
	}

	public void setFis(FileInputStream fis) {
		this.fis = fis;
	}
	public static void main(String[] args){
		IOStreamtest3 test = new IOStreamtest3();
		FileInputStream t;
		try {
			t=test.getFis();
			t.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
