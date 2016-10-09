package com.employee.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	
	private static Connection conn;
	
	public static Connection getConnection(){
		if (conn != null){
			return conn;
		}
		
		InputStream is = DBUtil.class.getClassLoader().getResourceAsStream("/resources/DB.properties");
		Properties prop = new Properties();
		try{
			prop.load(is);
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		}catch (IOException IOE){
			IOE.printStackTrace();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException SQLE){
			SQLE.printStackTrace();
		}
		
		return conn;
	}
	
	public static void closeConnection(Connection conn){
		if(conn == null){
			return;
		}
		
		try{
			conn.close();
		}catch(SQLException SQLe){
			SQLe.printStackTrace();
		}
	}
}
