package com.metacube.shoppingApp.dao;

import com.metacube.shoppingApp.model.CartItem;
import com.metacube.shoppingApp.model.Order;

/**
 * The Class QueryDao contains all the query related to database.{DAO LAYER}
 */
public class QueryDao {
	
	/**
	 * Check login status.
	 *
	 * @param id 
	 * @param pass
	 * @return string
	 */
	public String checkLoginStatus(int id ,String pass) {	
		return "SELECT * FROM users WHERE userid = "+id+" and password = '"+pass+"'";
	}
	
	/**
	 * add order in cart.
	 * @return
	 */
	public String addOrder() {
		
		return "INSERT INTO order_details(userid,total_cart_item,total_price) VALUES (?,?,?)";
	}
	

	
	/**
	 * Adds the product to cart.
	 *
	 * @param id 
	 * @param pid 
	 * @param pQty
	 * @return the string
	 */
	public String addProductToCart() {
		return "INSERT into cartItem(productid,productquantity,orderid) VALUES (?,?,?)";
	}
	
	
	/**
	 * Available products.
	 * @return the string
	 */
	public String availableProducts() {
		return "SELECT * FROM product";
	}

	/**
	 * Show product.
	 *
	 * @return the string
	 */
	public String showProduct() {
		return "SELECT * FROM product";
	}

	
}
