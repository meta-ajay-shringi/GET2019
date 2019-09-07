package com.metacube.shoppingApp.controller;

import java.util.List;

import com.metacube.shoppingApp.Service.Service;
import com.metacube.shoppingApp.enums.Status;
import com.metacube.shoppingApp.model.CartItem;
import com.metacube.shoppingApp.model.Order;
import com.metacube.shoppingApp.model.Product;

/**
 * This is controller class.
 */
public class Controller {

	private static Controller controllerObj;

	private Controller() {
	}

	public static Controller getInstance() {

		if (controllerObj == null) {
			controllerObj = new Controller();
			return controllerObj;
		} else {
			return controllerObj;
		}

	}

	Service serviceObj;

	public boolean getById(int id, String pass) {
		serviceObj = Service.getInstance();
		return serviceObj.getById(id, pass);
	}

	public List<Product> getAll() {
		serviceObj = Service.getInstance();
		return serviceObj.getAll();
	}

	public Status add(CartItem cartItem) {
		serviceObj = Service.getInstance();

		return serviceObj.add(cartItem);
	}

	public Status add(Order order) {
		serviceObj = Service.getInstance();

		return serviceObj.add(order);
	}



}
