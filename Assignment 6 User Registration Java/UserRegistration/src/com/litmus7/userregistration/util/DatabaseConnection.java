package com.litmus7.userregistration.util;

import java.util.*;
import java.io.*;
import java.sql.*;

public class DatabaseConnection {
	private static String username;
	private static String password;
	private static String url;
	static {
		Properties props = new Properties();
		try {
			props.load(new FileInputStream("sql/user_registration_db.properties"));
			url = props.getProperty("dburl");
			username = props.getProperty("username");
			password = props.getProperty("password");
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}
