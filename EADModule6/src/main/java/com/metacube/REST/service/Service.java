package com.metacube.REST.service;

import java.util.List;

import com.metacube.REST.dao.fruit.FruitDao;
import com.metacube.REST.enums.Status;
import com.metacube.REST.model.Fruits;

/**
 *  Service layer.
 */
public class Service {

	FruitDao fruitDaoObj = FruitDao.getInstance();

	private static Service serviceObj = null;

	private Service() {
	}

	public static Service getInstance() {

		if (serviceObj == null) {
			serviceObj = new Service();
			return serviceObj;
		} else {
			return serviceObj;
		}
	}

	/**
	 * Add fruits in database.
	 * @param fruitsObj, object of fruits.
	 * @return, status.
	 */
	public Status add(Fruits fruitsObj) {

		return fruitDaoObj.add(fruitsObj);
	}

	/**
	 * Delete all fruit.
	 * @return, status.
	 */
	public Status deleteAll() {

		return fruitDaoObj.deleteAll();
	}

	/**
	 * Update fruit quantity.
	 * @param fruitsObj
	 * @param param, parameter to be updated.
	 * @return, return status.
	 */
	public Status update(Fruits fruitsObj, String[] param) {

		return fruitDaoObj.update(fruitsObj, param);

	}

	/**
	 * Delete fruit by its object.
	 * @param fruitsObj
	 * @return, return status.
	 */
	public Status delete(Fruits fruitsObj) {

		return fruitDaoObj.delete(fruitsObj);
	}

}
