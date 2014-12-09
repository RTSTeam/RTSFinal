package com.mercury.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@Zhengjun-PC:1521:XE";	// change!!!
	private static final String USERNAME = "user_rts";  // change!!!
	private static final String PASSWORD = "l19891013"; // change!!!
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
