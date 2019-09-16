package com.metacube.EADSession11.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.metacube.EADSession11.model.BaseModel;

/**
 * interface of basedao.
 * @param <T>
 */
public interface BaseDao<T extends BaseModel> {

	public T getById(int id);

	public List<T> getAll();

	public void add(T t);

	public void delete(T t);

	public void update(T t, String param[]);

}
