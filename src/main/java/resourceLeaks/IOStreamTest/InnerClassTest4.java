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
	    //����������й�����һ�������ڲ���   
	    private void show() throws IOException{   
	        Out anonyInter=new Out(){// ��ȡ�����ڲ���ʵ��   
	               
	            void show(String s) throws IOException{//��д����ķ���   
	            	FileOutputStream fos=new FileOutputStream(new File(s));
	            }   
	        };   
	        anonyInter.show("test.txt");// �����䷽��   
	    }   
	}    
	  
	// ����һ���Ѿ����ڵ��࣬�����ڲ���ͨ����д�䷽���������������ʵ��   
	class Out{   
	    void show(String s) throws IOException{   
	        
	    }     
}
