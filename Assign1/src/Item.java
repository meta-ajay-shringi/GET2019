/* This class used to save item name, 
 * code and price.
 */
class Item {
	
	String itemName;
	int itemCode;
	double itemPrice;

	/* Constructor of Item
	 *@param code This is code of Item
	 *@param name This is name of Item
	 *@param price This is price of Item
	 */
	Item(int code, String name, Double price  )
	{
		itemName = name;
		itemCode = code;
		itemPrice = price;
	}
}	