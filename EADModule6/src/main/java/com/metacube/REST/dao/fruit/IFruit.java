package com.metacube.REST.dao.fruit;

import com.metacube.REST.dao.BaseDao;
import com.metacube.REST.enums.Status;
import com.metacube.REST.model.Fruits;

/**
 *  Interface of Ifruit.
 */
public interface IFruit extends BaseDao<Fruits> {
	
   public Status deleteAll();
   

}
