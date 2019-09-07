package com.metacube.shoppingApp.dao;

public interface JdbcDao<T> {
	
	abstract String getPrimaryKey();;
	abstract String getTableName();
	abstract T extractResultSet();
	
}
