package resourceLeaks.ioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOStreamtest29 {
	public class cls{
		FileInputStream fis;
		void open(String name) throws IOException{
			this.fis= new FileInputStream(new File(name));
		}
		void close() throws IOException{
			this.fis.close();
		}
	}
	public void foo1(cls X,cls Y) throws IOException{
		foo2(X,Y);
	}
	public void foo2(cls X,cls Y) throws IOException{
		X=Y;
		foox(X);
		fooy(Y);
	}
	public void foox(cls X) throws IOException{
		X.open("1.txt");
	}
	public void fooy(cls X) throws IOException{

		X.close();
	}
}
