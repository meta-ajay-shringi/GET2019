package com.metacube.REST.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.REST.model.Fruits;

/**
 * This class implement jdbc dao.
 */
public abstract class JdbcDaoImpl<T> implements JdbcDao {

	public abstract String getPrimaryKey();

	public abstract String getTableName();

	public abstract T extractResultSet(String queryString) throws ClassNotFoundException, SQLException, IOException;

	/**
	 * Method for get by Id.
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public T getById(int id) throws ClassNotFoundException, SQLException, IOException {

		String queryString = "SELECT * FROM '" + getTableName() + "' WHERE " + Integer.parseInt(getPrimaryKey()) + "=" + id;
		return extractResultSet(queryString);
	}

	/**
	 * Method for get all.
	 * @return
	 */
	public List<T> getAll() {
		
		List<T> list = new ArrayList<>();
		String queryString = "SELECT * FROM '" + getTableName() + "'";
		return list;
	}

}
