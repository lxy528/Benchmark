package sqlInjection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class sqltest {
	public void test(){
		String session="test";
		String sql ="select * from table where name ="+session;
		   Connection con = null; 
	        try {
	            con = DriverManager.getConnection(null);
	            con.prepareStatement(sql); /* BAD */
	            con.close();
	        } catch (SQLException e) {
	            System.err.println("An error occurred");
	        } finally {
	            try {
	                if(con != null) con.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	}
}
