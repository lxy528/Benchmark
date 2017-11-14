package xss;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class XSStest11 {
	class Widget {
        String value = null;
        public void setValue(String name) {
			this.value = name;
		}
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("abc");
        Widget w = new Widget();
        w.value = name;
        w.setValue("abc");;

        PrintWriter writer = resp.getWriter();
        writer.println(w.value);              /* OK */
    }
   
}
