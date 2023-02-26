package com.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {

	private static String url;
	private static String username;
	private static String password;
	
	
	static {
		ResourceBundle rb=ResourceBundle.getBundle("com.utility.dbDetails");
		url=rb.getString("url");
		username=rb.getString("username");
		password=rb.getString("password");
	}
	
	public static Connection provideConnection() {
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn=DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}

}
