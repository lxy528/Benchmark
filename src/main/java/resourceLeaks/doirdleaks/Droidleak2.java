package resourceLeaks.doirdleaks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Droidleak2 {

/*
 * A real resource leak example extracted from 
 * https://github.com/k9mail/k-9/commit/daeedc2222668827487a2c92470bccc57f7edf83
 */

public static boolean move(final File from, final File to) {
	
    if (to.exists()) {
        to.delete();
    }
    to.getParentFile().mkdirs();

    try {
        FileInputStream in = new FileInputStream(from);
        FileOutputStream out = new FileOutputStream(to);
        byte[] buffer = new byte[1024];
        int count = -1;
        while ((count = in.read(buffer)) > 0) {
            out.write(buffer, 0, count);
        }
        out.close();
        in.close();
        from.delete();
        return true;
    } catch (Exception e) {
      
        return false;
    
    }

    
 }
}
