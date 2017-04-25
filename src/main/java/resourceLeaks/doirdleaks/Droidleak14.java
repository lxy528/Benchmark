package resourceLeaks.doirdleaks;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/*
 * A real resource leak example extracted from 
 * https://github.com/cyclestreets/android/commit/68598b254dcfd89c03316bc41d58fc422157d912
 */
public class Droidleak14 {
	class Context{
		File CacheDir;

		public File getCacheDir() {
			return CacheDir;
		}

		public void setCacheDir(File cacheDir) {
			CacheDir = cacheDir;
		}
	}
	private static final int DEFAULT_BUFFER_SIZE = 40960;
	Context context_;
	private final Map<Integer, Long> daysToMs = new HashMap<Integer, Long>();
	private boolean isAvailable() 
	  {
	    return true;
	  } // isAvailable

	  private boolean expired(final File file, int maxAgeInDays)
	  {
	    final long now = new Date().getTime();
	    final long fileDate = file.lastModified();
	    
	    final long diff = now - fileDate;
	    final long expiry = expiryInMs(maxAgeInDays);
	    
	    return diff > expiry;
	  } // expired
	  private long expiryInMs(int maxAgeInDays)
	  {
	    final Long ms = daysToMs.get(maxAgeInDays);
	    if(ms != null)
	      return ms;
	    
	    final long toMs = maxAgeInDays * 24 * 60 * 60 * 1000;
	    daysToMs.put(maxAgeInDays, toMs);
	    return toMs;
	  } // expiryInMs
	byte[] fetch(final String name, int maxAgeInDays)
	  {
	    if(!isAvailable())
	      return null;
	    
	    final File file = dataFileName(name);
	    if(!file.exists())
	      return null;
	    
	    if(expired(file, maxAgeInDays))
	      return null;
	    
	    final ByteArrayOutputStream output = new ByteArrayOutputStream();
	    try 
	    {
	      final FileInputStream fis = new FileInputStream(file);
	      byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
	    
	      int n = 0;
	      while ((n = fis.read(buffer)) != -1)
	        output.write(buffer, 0, n);            
	      fis.close();
	    } // try
	    catch(IOException e)
	    {
	      return null;
	    } // catch
	    
	    return output.toByteArray();    
	  } // fetch

	 private File dataFileName(final String name)
	  {
	    final File cacheDir = context_.getCacheDir();
	    return new File(cacheDir, name);
	  } // dataFileName
}
