package resourceLeaks.ioStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class IOStreamtest22 {
	public void foo() {
		PrintWriter out = null;
		try{
			String file = null;
			try{
				String enc = null;
				out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file),enc));
			}catch(UnsupportedEncodingException ue){	
				out = new PrintWriter(new FileWriter(file));
			}  
			out.append("c");
		
		}catch (IOException e) {
		}finally {
			if(out!=null){
				out.close();
			}   
		}                   
	}
	public void foow(int x) throws IOException {
		FileOutputStream fileOutputStream = null;
		while(x-- > 0){
			fileOutputStream = new FileOutputStream(new File(""));
		}
		fileOutputStream.close();
	}
}
