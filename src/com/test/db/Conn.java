package com.test.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {

	
	private static String url = "";
	
	private static String username = "";
	
	private static String password = "";
	
	private static String className = "";
	
	public static Connection getConnection(){
		Connection conn = null;
		try{
			Class.forName(className);
			conn = DriverManager.getConnection(url, username, password);
		}catch(Exception e){
			e.printStackTrace();
		}		
		
		return conn;
	}
}
