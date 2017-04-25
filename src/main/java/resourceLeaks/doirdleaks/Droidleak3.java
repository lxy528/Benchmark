package resourceLeaks.doirdleaks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
//import org.apache.commons.io.IOUtils;
/*
 * A real resource leak example extracted from 
 * https://github.com/k9mail/k-9/commit/b53b0d33ba3d6aa70cfc1af8bfaf30e6b41bd442
 */
public class Droidleak3 {
	private static File keyStoreFile;
	 static {
	        
	        try {
	            javax.net.ssl.TrustManagerFactory tmf = javax.net.ssl.TrustManagerFactory.getInstance("X509");
	            //Application app = K9.app;
	            keyStoreFile = new File("");//app.getDir("KeyStore", Context.MODE_PRIVATE) + File.separator + "KeyStore.bks");
	          //  keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
	            java.io.FileInputStream fis;
	            try {
	                fis = new java.io.FileInputStream(keyStoreFile);
	            } catch (FileNotFoundException e1) {
	                fis = null;
	            }
	            try {
	               // keyStore.load(fis, "".toCharArray());
	                if(fis!=null)
	                	fis.close();
	            } catch (IOException e) {
	            	e.printStackTrace();
	            }
	          
	        } catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	        finally {
	          //  IOUtils.closeQuietly(fis);
	        }
	 }
}
