package resourceLeaks.ioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class IOStreamtest5 {
	public void foo(FileInputStream fis){
		FileInputStream temp_fis = null;
		try{
		fis= new FileInputStream(new File("1.txt"));
		temp_fis = fis;
		fis=new FileInputStream(new File("2.txt"));
		}
		catch (IOException e){
		e.printStackTrace();	
		}
		finally{
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (temp_fis != null)
				try {
					temp_fis.close();
				} catch (IOException te1) {
				}
		}
	}
}
