package testinho.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	private static Connection conn = null;
	
	public static Connection getConnection() {
		
		if(conn == null) {
			try {
		Class.forName("com.mysql.jdbc.Driver"); 
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myjdbc", "root", "root"); 
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			catch(ClassNotFoundException ex) {
				ex.printStackTrace();
			}
		} 
		return conn;
	}
	
	public static void closeConnection() {
		if(conn != null) {
			try {
			conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
