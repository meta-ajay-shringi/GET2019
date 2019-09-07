package com.metacube.shoppingApp.Service;

import java.util.List;

import com.metacube.shoppingApp.controller.Controller;
import com.metacube.shoppingApp.dao.cart.CartDao;
import com.metacube.shoppingApp.dao.order.OrderDao;
import com.metacube.shoppingApp.dao.product.ProductDao;
import com.metacube.shoppingApp.dao.user.UserDao;
import com.metacube.shoppingApp.enums.Status;
import com.metacube.shoppingApp.model.CartItem;
import com.metacube.shoppingApp.model.Order;
import com.metacube.shoppingApp.model.Product;

/**
 * Service layer.
 */

public class Service {

	ProductDao objProductDao = new ProductDao();
	UserDao ObjUserDao = new UserDao();
	CartDao ObjCartDao = new CartDao();
	OrderDao ObjOrderDao = new OrderDao();

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
	 * Checks login status.
	 *
	 * @param id
	 * @param pass
	 * @return true, if successful
	 */
	public boolean getById(int id, String pass) {
		return ObjUserDao.getById(id, pass);
	}

	public List<Product> getAll() {

		return objProductDao.getAll();
	}

	public Status add(Order order) {

		return ObjOrderDao.add(order);

	}

	public Status add(CartItem cartItem) {

		return ObjCartDao.add(cartItem);
	}
}
