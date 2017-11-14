package resourceLeaks.IOStreamTest;
import java.io.FileInputStream;
import java.io.IOException;

public interface FileIO13 {
	public void open(String a)throws IOException ;
	public void close(FileInputStream fis)throws IOException ;
}
