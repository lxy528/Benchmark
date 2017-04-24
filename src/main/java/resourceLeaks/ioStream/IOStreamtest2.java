package resourceLeaks.ioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOStreamtest2 {
	private FileInputStream fis;

	public FileInputStream getFis() {
		return fis;
	}

	public void setFis(FileInputStream fis) {
		this.fis = fis;
		try {
			this.fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void foo(){
		IOStreamtest2 test= new IOStreamtest2();
		try {
			FileInputStream  fis = new FileInputStream(new File("1.txt"));
			test.setFis(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
