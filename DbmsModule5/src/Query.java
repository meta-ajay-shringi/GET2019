
/**
 *  This class is used to call PROCEDURE.
 */
public class Query {
	
	/**
	 * Given the id of a user, fetch all orders (Id, Order Date, Order Total) 
	 * of that user which are in shipped state. Orders should be sorted by 
	 * order date column in chronological order.
	 * @return	An String type object containing query of Above problem. 
	 */
	public String orders(){
		return "CALL shipped_State(3,'Shipped')";
	}
	
	
	/**
	 * Insert five or more images of a product using batch insert technique.
	 * @return	An String type object containing query of Above problem. 
	 */
	public String image(){
		return "INSERT INTO images VALUES(105,?) ";
	}
	
	
	/**
	 * Set the FOREIGN_KEY_CHECKS = 0
	 * @return	An String type object containing query of Above problem.
	 */
	public String FOREIGN_KEY_CHECKS_0(){
		return "SET FOREIGN_KEY_CHECKS = 0 ";
	}
	
	
	/**
	 * Set the FOREIGN_KEY_CHECKS = 1
	 * @return	An String type object containing query of Above problem.
	 */
	public String FOREIGN_KEY_CHECKS_1(){
		return "SET FOREIGN_KEY_CHECKS = 1 ";
	}
	
	
	/**
	 * Show The Data from table where product is is 105.
	 * @return An String type object containing query of Above problem.
	 */
	public String select_Image(){
		return "CALL show_image()";
	}
	
	
	/**
	 * Select and display the category title of all top parent categories sorted 
	 * alphabetically and the count of their child categories.
	 * @return	An String type object containing query of Above problem.
	 */
	public String parent_Child(){
		return "CALL category_title()";
	}
	
	
	/**
	 * Delete all those products which were not ordered by any Shopper in last 1 year. 
	 * Return the number of products deleted.
	 * @return	An String type object containing query of Above problem.
	 */
	public String product_Not_order(){
		return "CALL delete_product()";
	}
}
