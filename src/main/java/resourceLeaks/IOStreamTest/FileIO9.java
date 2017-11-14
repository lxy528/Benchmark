package resourceLeaks.IOStreamTest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileIO9 {
	 public static Properties loadPropertiesBadly(String fileName)
	            throws IOException {
	        FileInputStream stream = new FileInputStream(fileName);
	        Properties props = new Properties();
	        props.load(stream);
	        stream.close();
	        return props;
	    }

}
