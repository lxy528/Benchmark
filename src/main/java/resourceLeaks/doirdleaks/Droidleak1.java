package resourceLeaks.doirdleaks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/*
 * 
 * A real resource leak example extracted from 
 * https://github.com/k9mail/k-9/commit/bbdec62e37210d6abf39cb32a8a6651483d88382
 */
public class Droidleak1 {
	private File mFile;
	class BinaryTempFileBodyInputStream extends FilterInputStream {
        public BinaryTempFileBodyInputStream(InputStream in) {
            super(in);
        }

        @Override
        public void close() throws IOException {
            try {
                super.close();
            } finally {
                mFile.delete();
            }
        }

        public void closeWithoutDeleting() throws IOException {
            super.close();
        }
    }
	public InputStream getInputStream() throws IOException {
		             return new BinaryTempFileBodyInputStream(new FileInputStream(mFile));
	}
}
		
