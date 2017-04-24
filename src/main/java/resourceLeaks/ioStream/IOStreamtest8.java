package resourceLeaks.ioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOStreamtest8 {
	public void foo(){
		try {
			FileInputStream fis = new FileInputStream(new File("1.txt"));
			fis.close();
			FileInputStream fis2=fis;
			fis2.read();
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
