package com.metacube.REST.dao;

/**
 * class for querys.
 */
public class QueryDao {

	/**
	 * Insert fruit.
	 * @return, query String.
	 */
	public static String insertFruits() {
		
		return "INSERT INTO fruit(fruit_name,quantity) VALUES (?,?) ";
	}
	
	/**
	 * Show all fruits.
	 * @return, query String.
	 */
	public static String showAllFruits() {
		
		return "SELECT * FROM fruit";
	}
	
	/**
	 * Update fruit quantity.
	 * @param name, name of fruit.
	 * @param quantity, new quantity of fruit.
	 * @return
	 */
	public static String updateFruitsQuantity(String name,int quantity) {
		
		return "UPDATE fruit SET quantity = " + quantity + " WHERE fruit_name = '" + name +"'";	
	}
	
	/**
	 * Delete all fruit from dataBase.
	 * @return, this return query String.
	 */
	public static String deleteAllData() {
		
		return "TRUNCATE TABLE fruit ";	
	}
	
	/**
	 * Delete fruit by name.
	 * @param name, name of fruit.
	 * @return, this return query string.
	 */
	public static String deleteFruit(String name) {
		
		return "DELETE FROM fruit WHERE fruit_name = '" + name +"'";
	}
}
