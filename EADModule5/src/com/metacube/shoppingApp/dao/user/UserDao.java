package com.metacube.shoppingApp.dao.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.metacube.shoppingApp.dao.BaseDao;
import com.metacube.shoppingApp.dao.ConnectionFactory;
import com.metacube.shoppingApp.dao.QueryDao;
import com.metacube.shoppingApp.enums.Status;
import com.metacube.shoppingApp.model.Product;
import com.metacube.shoppingApp.model.User;

public class UserDao implements BaseDao<User>{

	QueryDao objQueryDao = new QueryDao();
	ConnectionFactory objConnection =  new ConnectionFactory();
	
	/**
	 * This method is used to get all user by id.
	 * @param id, id of user
	 * @param pass, password of user.
	 * @return, return true is right entery.
	 */
	public boolean getById(int id,String pass) {
		
		String queryString = objQueryDao.checkLoginStatus(id, pass);
		
		try {
			PreparedStatement prestatement = objConnection.getConnection().prepareStatement(queryString);
			ResultSet resultSet = prestatement.executeQuery();
			resultSet.next();
			
			if(resultSet.getInt(1)==id && pass.equals(resultSet.getString(3))) {
				return true;
			}
			else {
				return false ;
			}
		} catch (SQLException e) {
			return false ;
		}	
		catch(Exception e) {
			return false;
		}
	}


	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Status add(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	public Status delete(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	public Status update(User t) {
		// TODO Auto-generated method stub
		return null;
	}


	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
