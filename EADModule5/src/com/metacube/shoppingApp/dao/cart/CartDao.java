package com.metacube.shoppingApp.dao.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.shoppingApp.dao.ConnectionFactory;
import com.metacube.shoppingApp.dao.QueryDao;
import com.metacube.shoppingApp.enums.Status;
import com.metacube.shoppingApp.model.CartItem;

public class CartDao implements ICartDao {

	QueryDao objQueryDao = new QueryDao();

	public CartItem getById(int id) {

		return null;
	}

	public List<CartItem> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This method is used to add item in cart.
	 */
	public Status add(CartItem cart) {

		String queryString = objQueryDao.addProductToCart();

		try {
			PreparedStatement pstmt = ConnectionFactory.getConnection().prepareStatement(queryString);

			pstmt.setInt(1, cart.getProductId());
			pstmt.setInt(2, cart.getQuantity());
			pstmt.setInt(3, cart.getOrderId());

			if (pstmt.executeUpdate() == 1) {
				return Status.ADDED;
			} else {
				return Status.ERROR;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Status.ERROR;
		}
	}

	public Status delete(CartItem t) {
		// TODO Auto-generated method stub
		return null;
	}

	public Status update(CartItem t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartItem getCartByOrderIdandProductCode() {
		// TODO Auto-generated method stub
		return null;
	}

}
