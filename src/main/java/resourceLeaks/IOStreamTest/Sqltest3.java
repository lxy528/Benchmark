package resourceLeaks.IOStreamTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Sqltest3 {
	 public static void main(String[] args) {
	        try {
	            String fileName = "c:/pmp.db";
	            Class.forName("org.sqlite.JDBC");
	            Connection conn = DriverManager.getConnection("jdbc:sqlite:"+ fileName);
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * FROM pmp_countries ORDER BY country_name ASC");
	            while (rs.next()) {
	                String id   = rs.getString("country_id");   // Column 1
	                String code = rs.getString("country_code"); // Column 2
	                String name = rs.getString("country_name"); // Column 3
	               
	                System.out.println("ID: "+ id +" Code: "+ code +" Name: "+ name);
	            }
	            //conn.close();
	            Sqltest2.pass(conn,stmt,rs);
	        }
	        catch (Exception e) {
	            // Print some generic debug info
	            System.out.println(e.getMessage());
	            System.out.println(e.toString());
	        }
	    }
}
