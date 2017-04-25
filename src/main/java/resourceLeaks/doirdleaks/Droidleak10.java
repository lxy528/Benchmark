package resourceLeaks.doirdleaks;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
 * A real resource leak example extracted from  
 * https://github.com/quran/quran_android/commit/4e4a60249a27cbf834d59db4611eb9f1843240c0
 */
public class Droidleak10 {

	private static final String DOWNLOAD_EXT = ".part";
	public static boolean isRunning = false;
	private class DownloadThread extends Thread {
		private static final int DOWNLOAD_BUFFER_SIZE = 2048;
		
		private String[] fileNames;
		private String[] downloadUrls;
		private String[] saveToDirectories;
		private boolean zipped;
		private int downloadIndex;
		private boolean resumeDownload() {
			BufferedInputStream in = null;
			FileOutputStream fos = null;
			BufferedOutputStream bout = null;
	
			try {
				for (; downloadIndex < fileNames.length; downloadIndex++) {
					int downloaded = 0;
					File f = new File(saveToDirectories[downloadIndex]);
					f.mkdirs();
					File file = new File(saveToDirectories[downloadIndex],
							fileNames[downloadIndex] + DOWNLOAD_EXT);
	
					URL url = new URL(downloadUrls[downloadIndex]);
					URLConnection conn = url.openConnection();
					int total = conn.getContentLength();
					//Log.d("quran_srv", "File to download: " + file.getName() + " - total length: " + total);
					HttpURLConnection connection = (HttpURLConnection) url
							.openConnection();
					if (file.exists()) {
						downloaded = (int) file.length();
						connection.setRequestProperty("Range", "bytes="
								+ (file.length()) + "-");
						//Log.d("quran_srv", "Resuming from " + downloaded);
						if (downloaded == total)
							continue;
					}
					connection.setRequestProperty("Range", "bytes="
							+ downloaded + "-");
					connection.setDoInput(true);
					in = new BufferedInputStream(connection.getInputStream());//resourceleak
					//in = new BufferedInputStream(connection.getInputStream(), DOWNLOAD_BUFFER_SIZE);
					fos = (downloaded == 0) ? new FileOutputStream(file
							.getAbsolutePath()) : new FileOutputStream(file
							.getAbsolutePath(), true);
	
					bout = new BufferedOutputStream(fos, DOWNLOAD_BUFFER_SIZE);
					byte[] data = new byte[DOWNLOAD_BUFFER_SIZE];
					int x = 0;
	
					while (isRunning && (x = in.read(data, 0, DOWNLOAD_BUFFER_SIZE)) >= 0) {
						bout.write(data, 0, x);
						downloaded += x;
						double percent = 100.0 * ((1.0 * downloaded) / (1.0 * total));
						updateProgress((int) percent, fileNames.length, downloadIndex);
					}
	//					bout.flush();
	//					bout.close();
	//					fos.close();
					
					if (isRunning) {
						file.renameTo(new File(saveToDirectories[downloadIndex], fileNames[downloadIndex]));
	
						if (zipped || fileNames[downloadIndex].endsWith(".zip"))
							unzipFile(saveToDirectories[downloadIndex], fileNames[downloadIndex]);
	
						//Log.d("quran_srv", "Download Completed [" + downloadUrls[downloadIndex] + "]");
					} else 
						return false;
				}
			} catch (FileNotFoundException e) {
				//Log.e("quran_srv", "File not found: IO Exception", e);
			} catch (IOException e) {
				//Log.e("quran_srv", "Download paused: IO Exception", e);
				return false;
			} catch (Exception e) {
				//Log.e("quran_srv", "Download paused: Exception", e);
				return false;
			}
	
			return true;
		}
		protected void unzipFile(String saveToDirectory, String fileName) {
			try {
				//Log.d("quran_srv", "Unziping file: " + saveToDirectory + fileName);
				// success, unzip the file...
				File file = new File(saveToDirectory, fileName);
				FileInputStream is = new FileInputStream(file);
				ZipInputStream zis = new ZipInputStream(is);

				ZipEntry entry;
				while ((entry = zis.getNextEntry()) != null) {
					if (entry.isDirectory()) {
						zis.closeEntry();
						continue;
					}

					// ignore files that already exist
					File f = new File(saveToDirectory, entry.getName());
					if (!f.exists()) {
						FileOutputStream ostream = new FileOutputStream(f);

						int size;
						byte[] buf = new byte[DOWNLOAD_BUFFER_SIZE];
						while ((size = zis.read(buf)) > 0)
							ostream.write(buf, 0, size);
						ostream.close();
					}
					zis.closeEntry();
				}

				zis.close();
				is.close();

				file.delete();
				//Log.d("quran_srv", "file unzipped successfully");
			} catch (IOException ioe) {
				//Log.e("quran_srv", "Error unzipping file: io exception: ", ioe);
			}
		}
		private void updateProgress(int percent, int totalFiles, int nDownloadedFiles) {
			percent = (int) (((double)percent / (double)100 + (double)nDownloadedFiles) / (double)totalFiles * 100);
			//service.updateProgress(percent);
//			notification.contentView.setTextViewText(R.id.text, "Downloading.. " + percent + "%");
//			notification.contentView.setProgressBar(R.id.progressBar, 100, percent, false);
//
//			//notify the notification manager on the update.
//			notificationManager.notify(ApplicationConstants.NOTIFICATION_DOWNLOADING, notification);
		}
	}
}
