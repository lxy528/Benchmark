//package resourceLeaks;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//public class IOStreamtest28Alias {
//	public class Xclass{
//		FileInputStream fis;
//
//		public FileInputStream getFis() {
//			return fis;
//		}
//
//		public void setFis(FileInputStream fis) {
//			this.fis = fis;
//		}
//		
//	}
//	public class Yclass{
//		Xclass x;
//		FileOutputStream fos;
//		public Xclass getX() {
//			return x;
//		}
//		public void setX(Xclass x) {
//			this.x = x;
//		}
//		public FileOutputStream getFos() {
//			return fos;
//		}
//		public void setFos(FileOutputStream fos) {
//			this.fos = fos;
//		}
//		
//	}
//	public  class Zclass{
//		Xclass x;
//		Yclass y;
//		public Xclass getX() {
//			return x;
//		}
//		public void setX(Xclass x) {
//			this.x = x;
//		}
//		public Yclass getY() {
//			return y;
//		}
//		public void setY(Yclass y) {
//			this.y = y;
//		}
//		
//	}
//	public void foo() throws IOException{
//		Xclass xc = new Xclass();
//		xc.fis=new FileInputStream(new File("1.txt"));
//		Yclass yc= new Yclass();
//		yc.setX(xc);
//		Zclass zc = new Zclass();
//		zc.y.setX(xc);
//		zc.setX(xc);
//		zc.y.x.fis.close();
//	}
//}
