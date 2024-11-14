package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection {
	
	static String path = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/tracker";
	static String uname = "root";
	static String pwd = "Pass@123";
	static Connection con = null;
	
	
	public static Connection getConnection() {
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url,uname,pwd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return con;
		
	}
	
	public static void main(String[] args) {
		try(Connection con = getConnection()){
			if(con != null) {
				System.out.println("Connection s=esta");
			}else {
				System.out.println("failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
