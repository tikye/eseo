package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConfiguration {
	
	private static final String DB_DRIVER = "org.h2.Driver";
	private static final String DB_CONNECTION = "jdbc:h2:tcp://localhost/~/test";

	 // Database credentials
	static final String USER = "SA";
	static final String PASS = "";
	static Connection connection = null;
	
	public static Connection getConnection(){

	 try {

	 Class.forName(DB_DRIVER);

	 if(connection == null) {
	connection = DriverManager.getConnection(DB_CONNECTION,USER,PASS);
	}
	} catch (ClassNotFoundException e) {
	e.printStackTrace();
	} catch (SQLException e1) {
	e1.printStackTrace();
	}
	return connection;
	}
	
}
