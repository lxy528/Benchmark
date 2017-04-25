package resourceLeaks.doirdleaks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*
 * A real resource leak example extracted from 
 * https://github.com/geometer/FBReaderJ/commit/ae9386682bf470b56faced3a9867ef54287cceee
 */
public class Droidleak4 {
	public class Book{
		long id;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}
		
	}
	Book getBookById(long id){
		return new Book();
	}
	public boolean saveCover(Book book, String url) {
		if (getBookById(book.getId()) == null) {
			return false;
		}
		
//		final ZLImage image = BookUtil.getCover(book);
//
//		if (image == null) {
//			return false;
//		}
//		if (image instanceof ZLLoadableImage) {
//			final ZLLoadableImage loadableImage = (ZLLoadableImage)image;
//			if (!loadableImage.isSynchronized()) {
//				loadableImage.synchronize();
//			}
//		}
//		final ZLAndroidImageData data =
//			((ZLAndroidImageManager)ZLAndroidImageManager.Instance()).getImageData(image);
//		if (data == null) {
//			return false;
//		}
//
//		final Bitmap coverBitmap = data.getFullSizeBitmap();
//		if (coverBitmap == null) {
//			return false;
//		}

		OutputStream outStream = null;
		File file = new File(url);
		File parent = file.getParentFile();
		parent.mkdirs();
		try {
			outStream = new FileOutputStream(file);
	 		//coverBitmap.compress(Bitmap.CompressFormat.PNG, 100, outStream);
	 		outStream.flush();
	 		outStream.close();
			} catch (FileNotFoundException e) {
	 		e.printStackTrace();
	 			return false;
			} catch (IOException e) {
	  			e.printStackTrace();
	  			return false;
			}
		return true;
	}
}
