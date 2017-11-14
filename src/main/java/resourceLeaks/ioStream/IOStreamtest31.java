package resourceLeaks.ioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;



public class IOStreamtest31 {
	public class Father{
		FileInputStream fis;
		public Father() throws IOException{
			if(fis!=null)
				fis.close();
		}
	}
	public class Child extends Father{

		public Child() throws IOException {
			fis=new FileInputStream(new File("1.txt"));
		}
		
	}
	public static void main(String[] args) {
		IOStreamtest31 test = new IOStreamtest31();
		try {
			Child c = (Child)test.new Father(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
