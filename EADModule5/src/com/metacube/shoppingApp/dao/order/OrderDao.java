package com.metacube.shoppingApp.dao.order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


import com.metacube.shoppingApp.dao.BaseDao;
import com.metacube.shoppingApp.dao.ConnectionFactory;
import com.metacube.shoppingApp.dao.QueryDao;
import com.metacube.shoppingApp.enums.Status;
import com.metacube.shoppingApp.model.CartItem;
import com.metacube.shoppingApp.model.Order;
import com.metacube.shoppingApp.model.Product;

public class OrderDao implements BaseDao<Order> {

	QueryDao objQueryDao = new QueryDao();
	
	
	@Override
	public Order getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This method is used to add order in database.
	 */
	@Override
	public Status add(Order order) {
		
     String queryString = objQueryDao.addOrder();
		
		try {
			PreparedStatement pstmt = ConnectionFactory.getConnection().prepareStatement(queryString);
			
			pstmt.setInt(1,order.getUserId() );
			pstmt.setInt(2, order.getTotalCartItem());
		    pstmt.setFloat(3, order.getTotalPrice());
			
		    if(pstmt.executeUpdate()==1){
				return Status.ADDED;
			}
			else{
				return Status.ERROR;
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			return Status.ERROR ;
		}
		
	}

	@Override
	public Status delete(Order t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status update(Order t) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
