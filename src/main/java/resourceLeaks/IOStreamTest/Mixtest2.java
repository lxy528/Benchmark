package resourceLeaks.IOStreamTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mixtest2 {
	public static void closefile(FileInputStream fs){
//		try {
//			fs.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	public static void closeconn(Connection conn){
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		
	}
	public static void closestate(Statement s){
//			try {
//				s.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	
	}
	public static void closeresult(ResultSet rs){
//		try {
//			rs.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	public static void test() throws IOException, SQLException{
		FileInputStream fStream  = new FileInputStream(new File("2.txt"));
		Connection conn = DriverManager.getConnection("jdbc:sqlite:"+ fStream.read());
		 Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM pmp_countries ORDER BY country_name ASC");
         closefile(fStream);//为什么是一三报错而不是都报呢，感觉应该是除了1都报呀
         closeconn(conn);
         closestate(stmt);
         closeresult(rs);
         
	}
}
