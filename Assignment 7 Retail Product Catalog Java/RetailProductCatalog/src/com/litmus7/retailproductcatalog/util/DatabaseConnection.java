package com.litmus7.retailproductcatalog.util;

import java.sql.*;
import java.util.Properties;
import java.io.*;

public class DatabaseConnection {
	private static String dburl;
	private static String username;
	private static String password;
	static {
		Properties props = new Properties();
		try {
			props.load(new FileInputStream("sql/product_catalog_db.properties"));
			dburl = props.getProperty("dburl");
			username = props.getProperty("username");
			password = props.getProperty("password");
		} catch (Exception e) {
			System.out.println("Error : " + e);
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dburl, username, password);
	}
}
