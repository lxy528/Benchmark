package xss;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//00387
public class XSStest6 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		String param = request.getParameter("BenchmarkTest00387");
		if (param == null) param = "";
		
		
		String bar;
		
		// Simple ? condition that assigns param to bar on false condition
		int num = 106;
		
		bar = (7*42) - num > 200 ? "This should never happen" : param;
		
		
		
response.setHeader("X-XSS-Protection", "0");
		response.getWriter().println(bar.toCharArray());
	}
	
}