package com.metacube.DAO;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used for make connection .
 */

public class ConnectionToDbms {

	public Connection connectionObject() {

		Connection connObj = null;

		try {

			Data data = new Data();

			// CREATING Connection to DATABASE.

			// STEP 2: Register JDBC driver
			Class.forName(data.getJdbcDriver());

			// Open a connection
			connObj = DriverManager.getConnection(data.getJdbcDbUrl(),
					data.getJdbcUser(), data.getJdbcPass());

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return connObj;
	}
}

