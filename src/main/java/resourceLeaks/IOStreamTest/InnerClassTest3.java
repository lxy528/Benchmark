package resourceLeaks.IOStreamTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class InnerClassTest3 {
	public void foo(String name) throws IOException
	{
		class InClass{
			public void foo1(String name)throws IOException{
				FileOutputStream fos=new FileOutputStream(new File(name));
			
			}
		}
		new InClass().foo1(name);
	}
	public void main(String[] args)throws IOException{
		InnerClassTest3 test=new InnerClassTest3();
		 test.foo("test.txt");
	}
}
