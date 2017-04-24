package resourceLeaks.ioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class IOStreamtest23{
	FileInputStream fos = null;
	public  void test () throws IOException  { 
		try {
			fos = new FileInputStream(new File("test.txt"));
			fos = ok();
			fos.read();
		} catch (FileNotFoundException e) {
			
		}finally{
			if(fos!=null)
				fos.close();
		}
		
	}
	public void pass() {
		FileInputStream x = fos;
		pass1(x);
	   
	}
	public void pass1(FileInputStream file){
		try {
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static FileInputStream ok(){
		try {
			return new FileInputStream(new File("test.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}

