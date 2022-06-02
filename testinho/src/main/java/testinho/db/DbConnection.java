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
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myjdbc?useSSL=false", "root", "root");
			}
			catch(SQLException e) {
				System.out.println("Could not connect to database: " + e.getMessage());
			}
			catch(ClassNotFoundException ex) {
				System.out.println("Class not found: "+ ex.getMessage());
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
				System.out.println("Could not close the connection: " + e.getMessage());
			}
		}
	}

}
