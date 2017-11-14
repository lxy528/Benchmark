package resourceLeaks.IOStreamTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class FileIO8 {
	public static void foo() throws IOException {
		 File out = new File("2.txt");
		GZIPOutputStream gzipOutputStream = new GZIPOutputStream(new FileOutputStream(out));
		gzipOutputStream.write(7);
		gzipOutputStream.close();
		
	}
}
