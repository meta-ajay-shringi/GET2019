package com.metacube.REST.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.metacube.REST.dao.fruit.FruitDao;
import com.metacube.REST.enums.Status;
import com.metacube.REST.model.Fruits;
import com.metacube.REST.service.Service;

/**
 *  This class is used to create resources.
 */

@Path("inventory")
public class FruitsController {

	Service serviceObj = Service.getInstance();

	/**
	 * This method is used to add all fruit in data base.
	 * @param fruitList, list of fruit.
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Status addFruits(List<Fruits> fruitList) {

		for (int index = 0; index < fruitList.size(); index++) {
			serviceObj.add(fruitList.get(index));
		}
		
		return Status.ADDED;
	}

	/**
	 * This class is used to delete all fruit then update them.
	 * @param fruitList, list of fruit.
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Status deleteAllAndUpdate(List<Fruits> fruitList) {

		serviceObj.deleteAll();

		for (int index = 0; index < fruitList.size(); index++) {
			serviceObj.add(fruitList.get(index));
		}
		
		return Status.DELETED;
	}
	

	/**
	 * Update fruit by fruit name. 
	 * @param name, name of fruit.
	 * @param fruitObj, fruit model class object.
	 * @return, return status updated.
	 */
	@PUT
	@Path("/{fruit_name}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Status update(@PathParam("fruit_name") String name, Fruits fruitObj) {

		String param[] = new String[10];
		param[0] = Integer.toString(fruitObj.getQuantity());

		return (serviceObj.update(fruitObj, param));
	}

	/**
	 * Delete all fruit.
	 * @return, return status.
	 */
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Status deleteAll() {

		return (serviceObj.deleteAll());
	}

	/**
	 * Delete fruit by its name.
	 * @param name, name of fruit.
	 * @param fruitObj, fruit model class object.
	 * @return, return deleted.
	 */
	@DELETE
	@Path("/{fruit_name}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Status deleteFruit(@PathParam("fruit_name") String name, Fruits fruitObj) {
		
		return (serviceObj.delete(fruitObj));
	}

}
