package xss;

//array 02030

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XSStest4 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String param = request.getParameter("BenchmarkTest02130");
		if (param == null) param = "";

		String bar = doSomething(param);
		
response.setHeader("X-XSS-Protection", "0");
		Object[] obj = { "a", bar};
		response.getWriter().printf(java.util.Locale.US,"Formatted like: %1$s and %2$s.",obj);
	}  // end doPost
	
		
	private static String doSomething(String param) throws ServletException, IOException {

		StringBuilder sbxyz60224 = new StringBuilder(param);
		String bar = sbxyz60224.append("_SafeStuff").toString();
	
		return bar;	
	}
}
