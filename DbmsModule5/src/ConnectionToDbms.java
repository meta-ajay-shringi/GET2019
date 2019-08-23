
//STEP 1. Import required packages
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionToDbms {

	public static void main(String[] args){

		try {

			Data data = new Data();

			// CREATING Connection to DATABASE.

			//STEP 2: Register JDBC driver
			Class.forName(data.getJdbcDriver());

			//Open a connection
			Connection connObj = DriverManager.getConnection(data.getJdbcDbUrl(),data.getJdbcUser(), data.getJdbcPass());

			DatabaseMetaData dbMetaData = connObj.getMetaData();

			// CREATING An Statement object.
			Statement stmt = connObj.createStatement();


			Query query = new Query();

			// ----------------------------------------------------------------------------------------------------
			/*
			 * Given the id of a user, fetch all orders (Id, Order Date, Order Total) 
			 * of that user which are in shipped state. Orders should be sorted by 
			 * order date column in chronological order.
			 */

			//STEP 4: Execute a query
			ResultSet rs = stmt.executeQuery(query.orders());
			List<Order> orderList = new ArrayList<Order>();

			while(rs.next()) {
				Order obj = new Order();
				obj.setOrderId(rs.getInt(1));
				obj.setOrderDate(rs.getString(2));
				obj.setOrderTotalPrice(rs.getInt(3));
				orderList.add(obj);
			}

			for(int index = 0; index < orderList.size(); index++){
				System.out.println("Order id: " + orderList.get(index).getOrderId()
						+" Order DATE : " +  orderList.get(index).getOrderDate()
						+" Order Total Price : " +  orderList.get(index).getOrderTotalPrice());
			}


			/*
			 * Insert five or more images of a product using batch insert technique.
			 */

			stmt.executeQuery(query.FOREIGN_KEY_CHECKS_0());

			PreparedStatement pstmt = connObj.prepareStatement(query.image());
			for(int i=1; i <= 5; i++){
				pstmt.setString(1,"image"+Integer.toString(i));
				pstmt.addBatch();
				pstmt.clearParameters();
			}
			pstmt.executeBatch();

			stmt.executeQuery(query.FOREIGN_KEY_CHECKS_1());

			ResultSet rs2 = stmt.executeQuery(query.select_Image());

			List<Product> ProductList = new ArrayList<Product>();
			Product objProduct = new Product();		
			while(rs2.next()) {

				objProduct.setProductId(rs2.getInt(1));
				objProduct.setImageName(rs2.getString(2));
				ProductList.add(objProduct);

			}

			for(int index = 0; index < ProductList.size(); index++){
				System.out.println("Product id: " + ProductList.get(index).getProductId()
						+" Image Name : " + ProductList.get(index).getImageName());
			}


			/*
			 * Select and display the category title of all top parent categories sorted 
			 * alphabetically and the count of their child categories.
			 */

			ResultSet rs3 =stmt.executeQuery(query.parent_Child());
			List<Category> CategoryList = new ArrayList<Category>();


			while(rs3.next()) {
				Category objCategory = new Category();
				objCategory.setTopCategoryName(rs3.getString(1));
				objCategory.setNumberOfChildren(rs3.getInt(2));

				CategoryList.add(objCategory);
			}

			for(int index = 0; index < CategoryList.size(); index++){
				System.out.println("Top Category Name: " + CategoryList.get(index).getTopCategoryName()
						+" Number Of Children : " + CategoryList.get(index).getNumberOfChildren());
			}


			/*
			 * Delete all those products which were not ordered by any Shopper in last 1 year. 
			 * Return the number of products deleted.
			 */

			stmt.executeQuery(query.FOREIGN_KEY_CHECKS_0());

			int a = stmt.executeUpdate(query.product_Not_order());
			System.out.println("Number of rows deleted in Product Table : "+a);

			stmt.executeQuery(query.FOREIGN_KEY_CHECKS_1());
			// ----------------------------------------------------------------------------------------------------				

			//STEP 6: Clean-up environment or Closing Connections to DATABASE.

			//Result Object Closed.
			rs.close();
			rs2.close();
			rs3.close();

			//Statement Object Closed.
			stmt.close();
			pstmt.close();

			//Connection Object Closed.
			connObj.close();		

		} catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
	}
}
