package com.metacube.REST.dao.fruit;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.metacube.REST.dao.ConnectionFactory;
import com.metacube.REST.dao.JdbcDaoImpl;
import com.metacube.REST.dao.QueryDao;
import com.metacube.REST.enums.Status;
import com.metacube.REST.model.Fruits;
import com.metacube.REST.service.Service;

/**
 * This class implement all method of IFruit and baseDao.
 */
public class FruitDao extends JdbcDaoImpl<Fruits> implements IFruit {

	private static FruitDao FruitDaoObj = null;

	private FruitDao() {
	}

	public static FruitDao getInstance() {

		if (FruitDaoObj == null) {
			FruitDaoObj = new FruitDao();
			return FruitDaoObj;
		} else {
			return FruitDaoObj;
		}
	}

	@Override
	public Fruits getById(int id) {

		return null;
	}

	@Override
	public Status add(Fruits fruitsObj) {

		String queryString = QueryDao.insertFruits();

		try {

			PreparedStatement pstmt = ConnectionFactory.getConnection().prepareStatement(queryString);
			pstmt.setString(1, fruitsObj.getFruitName());
			pstmt.setInt(2, fruitsObj.getQuantity());

			int updateValue = pstmt.executeUpdate();

			if (updateValue > 0) {
				return Status.ADDED;
			} else {
				return Status.ERROR;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Status.ERROR;
		}

	}

	@Override
	public String getPrimaryKey() {
		return "id";
	}

	@Override
	public String getTableName() {
		return "fruit";
	}

	@Override
	public Fruits extractResultSet(String queryString) throws ClassNotFoundException, SQLException, IOException {
		
		PreparedStatement preStatement = ConnectionFactory.getConnection().prepareStatement(queryString);
		ResultSet resultSet = preStatement.executeQuery();
		resultSet.next();
		return new Fruits(resultSet.getString(2), resultSet.getInt(3));
	}

	@Override
	public Status update(Fruits fruitsObj, String[] param) {

		try {
			String queryString = QueryDao.updateFruitsQuantity(fruitsObj.getFruitName(), Integer.parseInt(param[0]));

			Statement stmt = ConnectionFactory.getConnection().createStatement();
			int rs = stmt.executeUpdate(queryString);

			if (rs > 0) {
				return Status.UPDATED;
			} else {
				return Status.ERROR;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Status.ERROR;
		}

	}

	@Override
	public Status deleteAll() {

		try {
			String queryString = QueryDao.deleteAllData();

			Statement stmt = ConnectionFactory.getConnection().createStatement();
			int rs = stmt.executeUpdate(queryString);

			if (rs > 0) {
				return Status.DELETED;
			} else {
				return Status.ERROR;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Status.ERROR;
		}

	}

	@Override
	public Status delete(Fruits fruitsObj) {

		try {
			String queryString = QueryDao.deleteFruit(fruitsObj.getFruitName());

			Statement stmt = ConnectionFactory.getConnection().createStatement();
			int rs = stmt.executeUpdate(queryString);

			if (rs > 0) {
				return Status.DELETED;
			} else {
				return Status.ERROR;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Status.ERROR;
		}
	}

	@Override
	public List<Fruits> getAll() {

		return null;
	}

}
