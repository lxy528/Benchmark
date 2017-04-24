package resourceLeaks.ioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class IOStreamtest9 {
	public static Object obj; 
	public static void foo(){
		try {
			obj=new FileInputStream(new File("1.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
