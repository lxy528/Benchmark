package xss;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soot.baf.internal.BArrayLengthInst;


public class XSStest1 {

	class YClass{
		XClass xClass;
		@Override
		public String toString() {
			return xClass.toString();
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//int x = 0;
		response.setContentType("text/html;charset=UTF-8");
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("Referer");
		if (headers != null && headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}
		
		XClass xClass = new XClass();
		YClass yClass = new YClass();
		bar(param, xClass);
		barbar(yClass, xClass);
		response.setHeader("X-XSS-Protection", "0");
		Object[] obj = { "a", "b" };
		response.getWriter().format(java.util.Locale.US,yClass.toString(),obj);
//		response.getWriter().format(java.util.Locale.US,param,obj);
	}
	
	void bar(String par, XClass xClass){
		xClass.param = par;
	}
	void barbar( YClass yClass, XClass xClass){
		yClass.xClass = xClass;
	}
	
}
class XClass{
	public String param;
	@Override
	public String toString() {
		return param;
	}
}
