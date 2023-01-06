package common;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class DBUtil {
//db연결
	public static Connection getConnection() {
		Connection conn = null;
		try {
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/bigdata");
		conn = ds.getConnection();
		//etc.
		} catch(Exception e){
			e.printStackTrace();
		}
	return conn;
	}
	// @Deprecated은 비추한다는 뜻
	@Deprecated
	public static Connection getConnection2() {
		String url= "jdbc:mysql://localhost:3306/bigdata?serverTimezone=Asia/Seoul";
		String user= "root";
		String password= "bigdata";    
		Connection conn = null;
				
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	
	}
	//db해제
	public static void setClose(ResultSet rs, Statement stmt, Connection conn) {
		
		 try{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e){			
				e.printStackTrace();
			}
	}
}
