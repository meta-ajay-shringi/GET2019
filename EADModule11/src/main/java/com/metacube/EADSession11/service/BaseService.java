package com.metacube.EADSession11.service;

import java.util.List;

/**
 * Interface for base service.
 * @param <T>
 */
public interface BaseService<T> {

	public T getById(int id);

	public List<T> getAll();

	public void add(T t);

	public void delete(T t);

	public void update(T t, String param[]);

}
