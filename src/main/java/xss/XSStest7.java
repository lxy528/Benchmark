package xss;

//00642
import java.io.IOException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(value="/xss-01/BenchmarkTest00642")
public class XSStest7 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	
		helpers.SeparateClassRequest scr = new helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("BenchmarkTest00642");
		if (param == null) param = "";
		
		
		String bar = "";
		if (param != null) {
			java.util.List<String> valuesList = new java.util.ArrayList<String>( );
			valuesList.add("safe");
			valuesList.add( param );
			valuesList.add( "moresafe" );
			
			valuesList.remove(0); // remove the 1st safe value
			
			bar = valuesList.get(0); // get the param value
		}
		
		
response.setHeader("X-XSS-Protection", "0");
		response.getWriter().print(bar.toCharArray());
	}
	
}
