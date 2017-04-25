package resourceLeaks.doirdleaks;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
 * A real resource leak example extracted from  
 * https://github.com/mstorsjo/vlc-android/commit/6cd6fa17a3b70a98691d7d4f234e7e1d03524ef9
 */
public class Droidleak11 {
	  private boolean mShuffling = false;
	 private synchronized void loadLastPlaylist() {
//	        if (!AndroidDevices.hasExternalStorage())
//	            return;

	        String line;
	        FileInputStream input;
	        BufferedReader br;
	        int rowCount = 0;

	        int position = 0;
	        String currentMedia;
	        List<String> mediaPathList = new ArrayList<String>();

	        try {
	            // read CurrentMedia
	            input = new FileInputStream("");//AudioUtil.CACHE_DIR + "/" + "CurrentMedia.txt");
	            br = new BufferedReader(new InputStreamReader(input));
	            currentMedia = br.readLine();
	            mShuffling = "1".equals(br.readLine());
	            br.close(); 
	            input.close();

	            // read MediaList
	            input = new FileInputStream("");//AudioUtil.CACHE_DIR + "/" + "MediaList.txt");
	            br = new BufferedReader(new InputStreamReader(input));
	            while ((line = br.readLine()) != null) {
	                mediaPathList.add(line);
	                if (line.equals(currentMedia))
	                    position = rowCount;
	                rowCount++;
	            }
	            br.close();
	            input.close();
	            // load playlist
	         //   mInterface.load(mediaPathList, position, false);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 }
}
