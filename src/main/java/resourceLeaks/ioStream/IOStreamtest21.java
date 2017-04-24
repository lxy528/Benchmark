package resourceLeaks.ioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class IOStreamtest21 {
	public interface Father{
		public void foo();
	}
	public class Child implements Father{

		public void foo() {
			// TODO Auto-generated method stub
			System.out.println("hahah");
		}
		
	}
	public Child foos(){
		return new Child(){
			@Override
			public void foo() {
				try {
					FileInputStream	fis = new FileInputStream(new File("1.txt"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
	}
	public void foo(){
		Child c =foos();
		c.foo();
	}
}
