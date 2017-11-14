package resourceLeaks.ioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class IOStreamtest7 {
	public static class Innerclass{
		FileInputStream fis;

		public FileInputStream getFis() {
			return fis;
		}

		public void setFis(FileInputStream fis) {
			this.fis = fis;
		}
		
	}
	Innerclass test = new Innerclass();
	public  void foo(){
		try {
			FileInputStream fis = new FileInputStream(new File("1.txt"));
			test.setFis(fis);
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void main(){
		foo();
		try {
			test.fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
