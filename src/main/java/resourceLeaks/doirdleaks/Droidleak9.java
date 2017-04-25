package resourceLeaks.doirdleaks;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/*
 * A real resource leak example extracted from  
 * https://github.com/surespot/android/commit/01dceb79d6d6b8ce02cd2f789ff1ed62262dca37
 */


public class Droidleak9 {
	public static String inputStreamToString(InputStream is) throws IOException {
		String line = "";
		StringBuilder total = new StringBuilder();

		// Wrap a BufferedReader around the InputStream
		BufferedReader rd = new BufferedReader(new InputStreamReader(is));

		// Read response until the end
		while ((line = rd.readLine()) != null) {
			total.append(line);
		}

		// Return full string
//		rd.close();
//		is.close();
		return total.toString();
	}
	public static byte[] inputStreamToBytes(InputStream inputStream) throws IOException {
		ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
		int bufferSize = 1024;
		byte[] buffer = new byte[bufferSize];

		int len = 0;
		while ((len = inputStream.read(buffer)) != -1) {
			byteBuffer.write(buffer, 0, len);
		}
//		byteBuffer.close();
//		inputStream.close();
		return byteBuffer.toByteArray();
	}

	public static String inputStreamToBase64(InputStream inputStream) throws IOException {
		ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
		int bufferSize = 1024;
		byte[] buffer = new byte[bufferSize];

		int len = 0;
		while ((len = inputStream.read(buffer)) != -1) {
			byteBuffer.write(buffer, 0, len);
		}
//		byteBuffer.close();
//		inputStream.close();
		return new String(base64Encode(byteBuffer.toByteArray()));
	}
	public static String base64Encode(byte[] buf) {
		return "";
	}
}
