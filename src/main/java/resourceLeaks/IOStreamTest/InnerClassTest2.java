package resourceLeaks.IOStreamTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class InnerClassTest2 {
		public class inClass{
		public void foo(String filename) throws IOException{
			FileOutputStream fos=new FileOutputStream(new File(filename));
		}
	}
	public static void main(String[] args)throws IOException{
		String filename ="test.txt";
		InnerClassTest2.inClass cls= new InnerClassTest2().new inClass();
		cls.foo(filename);
	}
}
