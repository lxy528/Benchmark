package resourceLeaks.ioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOStreamtest28 {
	public class Father{


		FileInputStream fis;
	}
	public class Son extends Father{


		void close() throws IOException{
			this.fis.close();
		}
		
	}
	public void foo(Father f) throws IOException{
		((Son)f).close();
	}
	public void foo1() throws IOException{
		Father f= new Father();
		f.fis= new FileInputStream(new File("1.txt"));
		foo(f);
	}
}
