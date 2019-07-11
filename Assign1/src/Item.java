// Class of Item  
public class Item {

		String itemName;
		int itemCode;
		double itemPrice;
		int itemQuantity;
	
		/* Constructor of Item
		 * code of item
		 * Name of item
		 * Price of item
		 */
		Item(int code, String name, Double price  )
		{
			itemName = name;
			itemCode = code;
			itemPrice = price;
			itemQuantity = 0;
			
		}
}
