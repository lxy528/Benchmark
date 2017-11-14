package xss;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class XSStest12 {
	class Widget {
        String value = null;
        
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("abc");
        Widget w = new Widget();
        w.value = name;
        w.value = "abc";
        String bar = w.value;

        PrintWriter writer = resp.getWriter();
        writer.println(bar);              /* OK */
    }
   
}
