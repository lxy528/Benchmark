package sqlInjection;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SqlInjectiontest10 {
	public void foo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		SqlInjectiontest1 injectiontest1 = new SqlInjectiontest1();
		injectiontest1.doPost(request, response);
	}
}
