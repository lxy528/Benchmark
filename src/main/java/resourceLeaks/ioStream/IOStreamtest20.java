package resourceLeaks.ioStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOStreamtest20 {
	public void foo(){
		int s = 0;
		Xclass xclass = new Xclass();
		Yclass yclass1 = new Yclass();
		Yclass yclass2 = new Yclass();
		bar(xclass);
		set(xclass, yclass1);
		set(xclass, yclass2);
		close(yclass1);
		
	}
		
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
	void close(Yclass yclass1){
		try {
			yclass1.xclass.fOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Yclass{
	static Xclass xclass;
}