package resourceLeaks.doirdleaks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.crypto.Cipher;

/*
 * A real resource leak example extracted from  
 * https://github.com/guardianproject/ChatSecureAndroid/commit/d7d2b6066db81e874f90e5ee5328d946af3794e1
 */
public class Droidleak13 {
	private File mStoreFile;
	private final static String STORE_ALGORITHM = "PBEWITHMD5AND256BITAES-CBC-OPENSSL";
	private Properties mProperties = new Properties();
	public class OpenSSLPBEInputStream extends InputStream {

	    private final static int READ_BLOCK_SIZE = 64 * 1024;

	    private final Cipher cipher;
	    private final InputStream inStream;
	    private final byte[] bufferCipher = new byte[READ_BLOCK_SIZE];

	    private byte[] bufferClear = null;

	    private int index = Integer.MAX_VALUE;
	    private int maxIndex = 0;

	    public OpenSSLPBEInputStream(final InputStream streamIn, String algIn, int iterationCount, char[] password)
	            throws IOException {
	        this.inStream = streamIn;
	        try {
	            byte[] salt = readSalt();
	            cipher = null;//OpenSSLPBECommon.initializeCipher(password, salt, Cipher.DECRYPT_MODE, algIn, iterationCount);
	        } catch (Exception e) {
	            throw new IOException(e);
	        }
	    }
	    byte[] readSalt(){
	    	byte[] a=new byte[12];
	    	return a;
	    }
	    @Override
	    public int available() throws IOException {
	        return inStream.available();
	    }

	    @Override
	    public int read() throws IOException {

	        if (index > maxIndex) {
	            index = 0;
	            int read = inStream.read(bufferCipher);
	            if (read != -1) {
	                bufferClear = cipher.update(bufferCipher, 0, read);
	            }
	            if (read == -1 || bufferClear == null || bufferClear.length == 0) {
	                try {
	                    bufferClear = cipher.doFinal();
	                } catch (Exception e) {
	                    bufferClear = null;
	                }
	            }
	            if (bufferClear == null || bufferClear.length == 0) {
	                return -1;
	            }
	            maxIndex = bufferClear.length - 1;
	        }
	        
	        if (bufferClear == null || bufferClear.length == 0) {
	            return -1;
	        }
	        
	        return bufferClear[index++] & 0xff;
	       
	    }

	   

	}
	 private void loadOpenSSL(String password) throws IOException
     {
         
         if (!mStoreFile.exists())
             return;
         
         if (mStoreFile.length() == 0)
             return;
         
         FileInputStream fis = null;
         OpenSSLPBEInputStream encIS = null;
         try {

             fis = new FileInputStream(mStoreFile);

             
             // Decrypt the bytes
             encIS = new OpenSSLPBEInputStream(fis, STORE_ALGORITHM, 1, password.toCharArray());
             
                 mProperties.load(encIS);
             
         } catch (FileNotFoundException fnfe) {
             //OtrDebugLogger.log("Properties store file not found: First time?");
             mStoreFile.getParentFile().mkdirs();
         } finally {
             encIS.close();
             fis.close();
         }
     }
}
