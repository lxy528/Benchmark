package xss;

//02599

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Xsstest5 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String queryString = request.getQueryString();
		String paramval = "BenchmarkTest02599"+"=";
		int paramLoc = -1;
		if (queryString != null) paramLoc = queryString.indexOf(paramval);
		if (paramLoc == -1) {
			response.getWriter().println("getQueryString() couldn't find expected parameter '" + "BenchmarkTest02599" + "' in query string.");
			return;
		}
		
		String param = queryString.substring(paramLoc + paramval.length()); 
		int ampersandLoc = queryString.indexOf("&", paramLoc);
		if (ampersandLoc != -1) {
			param = queryString.substring(paramLoc + paramval.length(), ampersandLoc);
		}
		param = java.net.URLDecoder.decode(param, "UTF-8");

		String bar = doSomething(param);
		
		response.setHeader("X-XSS-Protection", "0");
		response.getWriter().write(bar.toCharArray());
	}  // end doPost
	
		
	private static String doSomething(String param) throws ServletException, IOException {

		String bar;
		
		// Simple if statement that assigns constant to bar on true condition
		int num = 86;
		if ( (7*42) - num > 200 )
		   bar = "This_should_always_happen"; 
		else bar = param;
	
		return bar;	
	}
}
