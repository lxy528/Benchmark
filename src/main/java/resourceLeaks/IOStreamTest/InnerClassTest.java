package resourceLeaks.IOStreamTest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class InnerClassTest {
	
	protected static class inClass{
		
		private  void foo(String filename) throws IOException{
			FileOutputStream fos=new FileOutputStream(new File(filename));
			//fos.write(7);
		}
	}
	public static void main(String[] args)throws IOException{
		String filename ="test.txt";
		InnerClassTest.inClass cls= new InnerClassTest.inClass();
		cls.foo(filename);
	}
}