package resourceLeaks.ioStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import resourceLeaks.supers.superTest1;
import resourceLeaks.supers.superTest2;

public class IOStreamtest19 {
	public void foo1() throws IOException{
		int x = 0;
		FileOutputStream fileOutputStream = new FileOutputStream(new File(""));
		superTest2 st = new t2class();
		st.set(fileOutputStream);
		st.close();
	}
	public void foo2() throws IOException{
		int x = 0;
		FileOutputStream fileOutputStream = new FileOutputStream(new File(""));
		superTest2 st = new s2class();
		st.set(fileOutputStream);
		st.close();
	}
}
class t2class implements superTest2{
	FileOutputStream file;
	@Override
	public void set(FileOutputStream f) {
		this.file = f;
	}
	@Override
	public void close() {
		try {
			this.file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class s2class implements superTest2{
	FileOutputStream file;
	@Override
	public void set(FileOutputStream f) {
		this.file = f;
	}
	@Override
	public void close() {
		int x = 0;
		System.out.println(x);
	}
}