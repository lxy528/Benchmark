//package resourceLeaks.ioStream;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//
//
//public class IOStreamtest32 {
//	public class Father{
//		FileInputStream fis;
//		public Father() throws IOException{
//			if(fis!=null)
//				fis.close();
//		}
//	}
//	public class Child extends Father{
//
//		public Child() throws IOException {
//			fis=new FileInputStream(new File("1.txt"));
//		}
//		
//	}
//	public static void main(String[] args) {
//		IOStreamtest32 test = new IOStreamtest32();
//		try {
//			Father f = (Father)test.new Child(); 
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}
