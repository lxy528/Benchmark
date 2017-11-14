package resourceLeaks.IOStreamTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InnerClassTest4 {

	    public static void main(String args[])throws IOException{   
	    	InnerClassTest4 test=new InnerClassTest4();   
	        test.show();   
	    }   
	    //在这个方法中构造了一个匿名内部类   
	    private void show() throws IOException{   
	        Out anonyInter=new Out(){// 获取匿名内部类实例   
	               
	            void show(String s) throws IOException{//重写父类的方法   
	            	FileOutputStream fos=new FileOutputStream(new File(s));
	            }   
	        };   
	        anonyInter.show("test.txt");// 调用其方法   
	    }   
	}    
	  
	// 这是一个已经存在的类，匿名内部类通过重写其方法，将会获得另外的实现   
	class Out{   
	    void show(String s) throws IOException{   
	        
	    }     
}
