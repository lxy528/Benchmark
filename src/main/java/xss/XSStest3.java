package xss;
//1917
import java.io.IOException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(value="/xss-03/BenchmarkTest01917")
public class XSStest3 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String param = "";
		if (request.getHeader("Referer") != null) {
			param = request.getHeader("Referer");
		}
		
		// URL Decode the header value since req.getHeader() doesn't. Unlike req.getParameter().
		param = java.net.URLDecoder.decode(param, "UTF-8");

		String bar = doSomething(param);
		
response.setHeader("X-XSS-Protection", "0");
		response.getWriter().print(bar);
	}  // end doPost
	
		
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = org.owasp.esapi.ESAPI.encoder().encodeForHTML(param);
	
		return bar;	
	}
}