package resourceLeaks.doirdleaks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * A real resource leak example extracted from 
 * https://github.com/thialfihar/apg/commit/f5aa36ef9f092240f99cb64b83cc64b91544d638
 */

public class Droidleak16 {
	private static void copy(File in, File out) throws IOException {
        FileInputStream is = new FileInputStream(in);
        FileOutputStream os = new FileOutputStream(out);
       byte[] buf = new byte[512];
        while (is.available() > 0) {
            int count = is.read(buf, 0, 512);
            os.write(buf, 0, count);
     
        }
    }
}
