package com.metacube.shoppingApp.dao;

import java.util.List;

import com.metacube.shoppingApp.enums.Status;
import com.metacube.shoppingApp.model.BaseModel;



/**
 * interface of basedao.
 * @param <T>
 */
public interface BaseDao<T extends BaseModel> {
	
	public T getById(int id);
	
	public List<T> getAll();
	
	public Status add(T t);
	
	public Status delete(T t);
	
	public Status update(T t);
	
}
