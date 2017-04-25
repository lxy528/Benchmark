package resourceLeaks.doirdleaks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*
 * A real resource leak example extracted from 
 * https://github.com/thialfihar/apg/commit/f5aa36ef9f092240f99cb64b83cc64b91544d638
 */
public class Droidleak15 {
	
	public class ExportResult  {
		public static final int RESULT_ERROR = 1;
		public ExportResult(){
			
		}
		public ExportResult(int resultError, Object log) {
			// TODO Auto-generated constructor stub
		}

		public boolean cancelled() {
			// TODO Auto-generated method stub
			return false;
		}

	}
	
	  public ExportResult exportToFile(long[] masterKeyIds, boolean exportSecret, String outputFile) {

//	        OperationLog log = new OperationLog();
//	        if (masterKeyIds != null) {
//	            log.add(LogType.MSG_EXPORT, 0, masterKeyIds.length);
//	        } else {
//	            log.add(LogType.MSG_EXPORT_ALL, 0);
//	        }
//
//	        // do we have a file name?
//	        if (outputFile == null) {
//	            log.add(LogType.MSG_EXPORT_ERROR_NO_FILE, 1);
//	            return new ExportResult(ExportResult.RESULT_ERROR, log);
//	        }
//
//	        // check if storage is ready
//	        if (!FileHelper.isStorageMounted(outputFile)) {
//	            log.add(LogType.MSG_EXPORT_ERROR_STORAGE, 1);
//	            return new ExportResult(ExportResult.RESULT_ERROR, log);
//	        }
		  Object log = null;
	        try {
	            OutputStream outStream = new FileOutputStream(outputFile);
	            ExportResult result =  new ExportResult();//(log, masterKeyIds, exportSecret, outStream);
	                        if (result.cancelled()) {
	                           //noinspection ResultOfMethodCallIgnored
	                            new File(outputFile).delete();
	                            return result;
	            }
	                      
	     } catch (FileNotFoundException e) {
	     
	          
				// log.add(LogType.MSG_EXPORT_ERROR_FOPEN, 1);
	            return new ExportResult(ExportResult.RESULT_ERROR, log);
	        }
			return new ExportResult(ExportResult.RESULT_ERROR, log);

	    }
}
