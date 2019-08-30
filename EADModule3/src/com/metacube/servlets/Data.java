package com.metacube.servlets;

public class Data {
	// JDBC Driver Name & Database URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String JDBC_DB_URL = "jdbc:mysql://localhost:3306/student_data";

	// JDBC Database Credentials
	static final String JDBC_USER = "root";
	static final String JDBC_PASS = "ajay@1308";

	public static String getJdbcDriver() {
		return JDBC_DRIVER;
	}

	public static String getJdbcDbUrl() {
		return JDBC_DB_URL;
	}

	public static String getJdbcUser() {
		return JDBC_USER;
	}

	public static String getJdbcPass() {
		return JDBC_PASS;
	}
}
