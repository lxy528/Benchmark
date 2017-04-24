package resourceLeaks.ioStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOStreamtest15 {
	Yclass cYclass;
	class Yclass{
		public Xclass xclass;}
	public void foo(){
		//int s = 0;
		Xclass xclass = new Xclass();
		Yclass yclass = new Yclass();
		bar(xclass);
		set(xclass, yclass);
		close(yclass);}
	void bar(Xclass xclass){
		
		try{
			FileOutputStream fOutputStream  = new FileOutputStream(new File(""));
			xclass.fOutputStream = fOutputStream;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	void set(Xclass x,Yclass y){
		y.xclass = x;
	}
	void close(Yclass y){
		try {
			y.xclass.fOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class Xclass{
	FileOutputStream fOutputStream;
}
