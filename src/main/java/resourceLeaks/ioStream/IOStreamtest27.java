package resourceLeaks.ioStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class IOStreamtest27 {
	public void main(String[] args) throws IOException {
		 OutputStream out = new FileOutputStream(new File(""));
	     try {
	    	 out.write(0);
	     } finally {
	         out.close();
	     }
	}
	
	public void main1() throws IOException {
		FileOutputStream out = new FileOutputStream(new File(""));
		FileOutputStream out1 = out;
		FileOutputStream out2 = pass(out1);
	    out2.close();
	     
	}
	
	public FileOutputStream pass(FileOutputStream outputStream) {
		FileOutputStream outputStream2 = outputStream;
		FileOutputStream outputStream3 = pass1(outputStream);
		return outputStream3;
	}
	
	public FileOutputStream pass1(FileOutputStream outputStream) {
		FileOutputStream outputStream2 = outputStream;
		FileOutputStream outputStream3 = outputStream2;
		FileOutputStream outputStream4 = outputStream3;
		return outputStream4;
	}
	
	
	
}
