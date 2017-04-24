package resourceLeaks.supers;

import java.io.File;
import java.io.FileOutputStream;

public abstract class superTest1 {
	public FileOutputStream file;
	public void set(FileOutputStream f){};
	public void close() {}
}
