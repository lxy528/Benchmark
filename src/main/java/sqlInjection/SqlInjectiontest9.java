package sqlInjection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SqlInjectiontest9 {
	
	
	public void foo(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Class <?> clz= Class.forName("SqlInjectiontest8");
		SqlInjectiontest8 test =(SqlInjectiontest8) clz.newInstance();
		test.doPost(request, response);
	}
}
