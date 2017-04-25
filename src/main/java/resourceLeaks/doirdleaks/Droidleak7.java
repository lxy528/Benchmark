package resourceLeaks.doirdleaks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Handler;

import org.xml.sax.SAXException;

/*
 * A real resource leak example extract from
 * https://github.com/cgeo/cgeo/blob/20e76ededc86ee19c1fc1fe127d428820d1add2f/src/cgeo/geocaching/cgGPXParser.java
 */

public class Droidleak7 {
		public static class Xml{
			static void parse(FileInputStream file){
				
			}
		}
		class Search {
			long Currentid;

			public long getCurrentId() {
				return Currentid;
			}

			public void setCurrentId(long currentid) {
				Currentid = currentid;
			}
		}
		private Search search;
		public long parse(File file, int version, Handler handlerIn) {

		//	final RootElement root = new RootElement(ns, "gpx");
		try {
	 			Xml.parse(new FileInputStream(file));//, Xml.Encoding.UTF_8, root.getContentHandler());
	 
	 			return search.getCurrentId();
	 		} catch (Exception e) {
	 			//Log.e(cgSettings.tag, "Cannot parse .gpx file " + file.getAbsolutePath() + " as GPX " + version + ": " + e.toString());
	 		}
		return 0l;
	}
}
