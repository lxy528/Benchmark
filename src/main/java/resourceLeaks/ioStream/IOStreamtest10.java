package resourceLeaks.ioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOStreamtest10 {
	public static FileInputStream fis;
	public static void foo(){
		try {
			fis=new FileInputStream(new File("1.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(){
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void notclose(){
		System.out.println("aha!");
	}
	public static void main(String [] args){
		foo();
		notclose();
	}
}
