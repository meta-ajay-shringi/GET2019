package com.metacube.shoppingApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//import com.metacube.shoppingApp.dao.ReadPropertiesFile;

/**
 * The Class JdbcConnection.
 */
public class ConnectionFactory {

	static Connection objConnection;

	/**
	 * Gets the obj connection.
	 * @return the obj connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException,
	SQLException {
		if (objConnection == null) {
			Properties prop = new Properties();
			ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile();
			prop = readPropertiesFile.ReadFile();
			Class.forName(prop.getProperty("connectionClass"));
			objConnection = DriverManager
					.getConnection((prop.getProperty("url") + prop
							.getProperty("databaseName")), prop
							.getProperty("username"), prop
							.getProperty("password"));
		}
		return objConnection;
	}
}
