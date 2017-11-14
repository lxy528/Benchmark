package xss;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Xsstest10 {
	public void foo(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Class<?> cls = Class.forName("XSStest9");
		XSStest9 test= (XSStest9) cls.newInstance();
		test.doPost(request, response);
	}
}
