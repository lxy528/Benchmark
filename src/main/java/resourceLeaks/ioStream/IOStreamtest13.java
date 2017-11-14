package resourceLeaks.ioStream;

import java.io.File;
import java.io.FileInputStream;

public class IOStreamtest13 {
	
	public  static void main(String [] args)throws Exception{
		Class<?> cls = Class.forName("resourceleaks.IOStreamtest7$Innerclass");
		IOStreamtest7.Innerclass inner= (IOStreamtest7.Innerclass)cls.newInstance();
		inner.setFis(new FileInputStream(new File("1.txt")));
		System.out.println();
	}
	
}
