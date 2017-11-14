package resourceLeaks.ioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;



public class IOStreamtest30 {
	public class Father{
		FileInputStream fis;
		public Father() throws IOException{
			fis = new FileInputStream(new File("1.txt"));
		}
	}
	public class Child extends Father{

		public Child() throws IOException {
			super();
			fis.close();
		}
		
	}
	public static void main(String[] args) {
		IOStreamtest30 test = new IOStreamtest30();
		try {
			Child c = (Child)test.new Father(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
