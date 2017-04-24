package resourceLeaks.ioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class IOStreamtest4 {
	public void foo(){
		FileInputStream fis=null;
		try{
		 fis= new FileInputStream(new File("1.txt"));
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
		}
	}
}
