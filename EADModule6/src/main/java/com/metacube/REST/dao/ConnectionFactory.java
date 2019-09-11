package com.metacube.REST.dao;

import java.io.IOException;
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

	private static Connection objConnection;

	/**
	 * Gets the obj connection.
	 * @return the obj connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException 
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
		
		if (objConnection == null) {
			Properties prop = new Properties();
			ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile();
			prop = readPropertiesFile.readFile();
			Class.forName(prop.getProperty("connectionClass"));
			objConnection = DriverManager.getConnection((prop.getProperty("url") + prop.getProperty("databaseName")), prop.getProperty("username"), prop.getProperty("password"));
		}
		return objConnection;
	}
}
