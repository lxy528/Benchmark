package resourceLeaks.IOStreamTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mixtest1 {
	public static void test() throws IOException, SQLException{
		FileInputStream fStream  = new FileInputStream(new File("2.txt"));
		Connection conn = DriverManager.getConnection("jdbc:sqlite:"+ fStream.read());
		 Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM pmp_countries ORDER BY country_name ASC");
         if(fStream!=null)
        	 fStream.close();
         if(conn!=null)
        	 conn.close();
        if(stmt!=null)
        	stmt.close();
        if(rs!=null)
        	rs.close();
        
	}
}
