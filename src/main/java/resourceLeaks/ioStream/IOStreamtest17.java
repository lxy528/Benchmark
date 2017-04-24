package resourceLeaks.ioStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class IOStreamtest17 {
	Yclass cYclass;
	class Yclass{
		 Xclass xclass;
		public Xclass getXclass() {
			return xclass;
		}
		public void setXclass(Xclass xclass) {
			this.xclass = xclass;
		}
	}
	class Xclass{
		FileOutputStream fOutputStream;

		public FileOutputStream getfOutputStream() {
			return fOutputStream;
		}
		public void setfOutputStream(FileOutputStream fOutputStream) {
			this.fOutputStream = fOutputStream;
		}
	}
	public void foo(){
		int x;
		Xclass xclass = new Xclass();
		Yclass yclass = new Yclass();
		bar(xclass);
		set(xclass, yclass);
		close(yclass);
	}
	void bar(Xclass xclass){
		int x;
		try{
			FileOutputStream fOutputStream  = new FileOutputStream(new File(""));
			xclass.setfOutputStream(fOutputStream);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	void set(Xclass x,Yclass y){
		y.setXclass(x);
		//cYclass = y;
	}
	void close(Yclass y){
		try {
			y.getXclass().getfOutputStream().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
