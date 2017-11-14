package resourceLeaks.IOStreamTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.xml.internal.ws.Closeable;

public class Sqltest5 {
	public static void closestate(Statement stmt){
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 public static void main(String[] args) throws Exception {
	        Connection conn = null;
	        String sql;
	        // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
	        // 避免中文乱码要指定useUnicode和characterEncoding
	        // 执行数据库操作之前要在数据库管理系统上创建一个数据库，名字自己定，
	        // 下面语句之前就要先创建javademo数据库
	        String url = "jdbc:mysql://localhost:3306/javademo?"
	                + "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
	 
	        try {
	            // 之所以要使用下面这条语句，是因为要使用MySQL的驱动，所以我们要把它驱动起来，
	            // 可以通过Class.forName把它加载进去，也可以通过初始化来驱动起来，下面三种形式都可以
	            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
	            // or:
	            // com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
	            // or：
	            // new com.mysql.jdbc.Driver();
	 
	            System.out.println("成功加载MySQL驱动程序");
	            // 一个Connection代表一个数据库连接
	            conn = DriverManager.getConnection(url);
	            // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
	            Statement stmt = conn.createStatement();
	            sql = "create table student(NO char(20),name varchar(20),primary key(NO))";
	            int result = stmt.executeUpdate(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
	            if (result != -1) {
	                System.out.println("创建数据表成功");
	                sql = "insert into student(NO,name) values('2012001','陶伟基')";
	                result = stmt.executeUpdate(sql);
	                sql = "insert into student(NO,name) values('2012002','周小俊')";
	                result = stmt.executeUpdate(sql);
	                sql = "select * from student";
	                ResultSet rs = stmt.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空值
	                System.out.println("学号\t姓名");
	                while (rs.next()) {
	                    System.out
	                            .println(rs.getString(1) + "\t" + rs.getString(2));// 入如果返回的是int类型可以用getInt()
	                }
	                Sqltest6.closers(rs);
	            }
	            closestate(stmt);
	            System.out.println(result);
	        } catch (SQLException e) {
	            System.out.println("MySQL操作错误");
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	        	if(conn!=null)
	            conn.close();
	        }
	 
	    }
}
