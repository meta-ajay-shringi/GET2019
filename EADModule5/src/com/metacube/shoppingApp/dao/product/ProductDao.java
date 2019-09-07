package com.metacube.shoppingApp.dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




import com.metacube.shoppingApp.dao.BaseDao;
import com.metacube.shoppingApp.dao.ConnectionFactory;
import com.metacube.shoppingApp.dao.QueryDao;
//import com.metacube.EADSession5.dao.SQLConnector;
import com.metacube.shoppingApp.enums.Status;
import com.metacube.shoppingApp.model.Product;

public class ProductDao implements BaseDao<Product> {


	QueryDao objQueryDao = new QueryDao();
	ConnectionFactory objConnection =  new ConnectionFactory();
	
	/**
	 * This method is used to gettAll product.
	 */
	public List<Product> getAll() {
		
		List<Product> productList = new ArrayList<>();
		String queryString = objQueryDao.showProduct();
		try{
			PreparedStatement preStatement = objConnection.getConnection().prepareStatement(queryString);
			ResultSet resultSet = preStatement.executeQuery();
			while(resultSet.next()){
				productList.add(new Product(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(4),resultSet.getFloat(3)));
			}
			return productList;
		}catch(Exception e){
			return null;
		}
		
		
	}

	

	public Status delete(Product t) {
		// TODO Auto-generated method stub
		return null;
	}

	public Status update(Product t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Status add(Product t) {
		// TODO Auto-generated method stub
		return null;
	}

     

	


}
