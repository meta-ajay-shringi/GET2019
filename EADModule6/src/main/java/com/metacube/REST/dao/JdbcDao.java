package com.metacube.REST.dao;

import java.io.IOException;
import java.sql.SQLException;

/**
 *  Interface of jdbc dao.
 */
public interface JdbcDao<T> {
	
	public abstract String getPrimaryKey();
	public abstract String getTableName();
	public abstract T extractResultSet(String queryString)  throws ClassNotFoundException, SQLException, IOException;;
	
}
