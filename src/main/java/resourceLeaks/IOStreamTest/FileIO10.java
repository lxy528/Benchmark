package resourceLeaks.IOStreamTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileIO10 {
	public static Properties loadProperties(String fileName) 
            throws IOException {
        FileInputStream stream = new FileInputStream(fileName);
        try {
            Properties props = new Properties();
            props.load(stream);
            return props;
        }
        finally {
            stream.close();
        }
    }

}
