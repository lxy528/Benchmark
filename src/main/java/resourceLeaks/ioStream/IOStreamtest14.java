package resourceLeaks.ioStream;

import java.lang.reflect.Method;

public class IOStreamtest14 {
	public static void main(String[] args) throws Exception{
		Class<?> class1 =  Class.forName("resourceleaks.IOStreamtest11");
		Object test =  class1.newInstance();
		Method m = class1.getMethod("foo");
		m.invoke(test);
		System.out.println(((IOStreamtest11)test).fis);
	}
}
