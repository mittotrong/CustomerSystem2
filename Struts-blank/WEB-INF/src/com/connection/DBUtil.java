package com.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection conn = null;
	
	public static Connection getConnection() {
		if(conn!=null){
			return conn;
			
		} else {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url = "jdbc:sqlserver://localhost:1433;databaseName=CustomerSystem";
				conn = DriverManager.getConnection(url,"sa","D1q6t1jw9c94ch");
				if (conn != null) {
				      System.out.println("Connected");}
		   } catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Class Not Found Exception" + e);

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("SQL Exception" + e);
		}
		return conn;
	}
	}
}
