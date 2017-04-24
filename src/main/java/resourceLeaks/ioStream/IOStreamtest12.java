package resourceLeaks.ioStream;

public class IOStreamtest12 {
	public static void main(String[] args) throws Exception{
		Class<?> class1 = null;
		class1 = Class.forName("resourceleaks.IOStreamtest11");
		IOStreamtest11 test = (IOStreamtest11) class1.newInstance();
		test.foo();
		System.out.println(test.fis);
	}
}
