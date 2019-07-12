import java.util.ArrayList;
import java.util.Scanner;

/* 
 * This class have functionality to add item, update 
 * quantity, display  and generate bill.
 */
public class ShopingCart {

	static ArrayList<Item> itemList = new ArrayList<Item>();
	static ArrayList<Cart> itemInCart = new ArrayList<Cart>();

	/* 
	 * This method is used to 
	 * save item in itemList.
	 *  */
	public static void availableItem() {
		Item Ball = new Item(1, "Ball", 80.00);
		itemList.add(Ball);

		Item Shoes = new Item(2, "Shoes", 1200.00);
		itemList.add(Shoes);

		Item Bat = new Item(3, "Bat", 700.00);
		itemList.add(Bat);

		Item Cap = new Item(4, "cap", 100.00);
		itemList.add(Cap);

		Item cup = new Item(5, "cup", 50.00);
		itemList.add(cup);
	}

	/* 
	 * This methord is used to show
	 *  all available item. 
	 * */
	public static void showAvailableItem() {
		System.out.println("Item Available For You");
		System.out.println("Code  Name  Price  ");

		for (int i = 0; i < itemList.size(); i++) {
			System.out.println(itemList.get(i).itemCode + "     "+ itemList.get(i).itemName + "    "+ itemList.get(i).itemPrice);
		}
	}

	/*
	 *  This method is used to add item in cart
	 * @param code This is code of item.
	 * @param quentity This is quentity of item.
	 */
	public static void addToCart(int code, int quentity) {
		Cart aItem = new Cart();
		aItem.productCode = code;
		aItem.productQuantity = quentity;
		itemInCart.add(aItem);
	}

	/*
	 * This method used to show all available item in cart with item code,
	 * name,price , quantity.
	 */
	public static void displayItemInCart() {
		System.out.println("Code  Name  Price  Quantity");
		for (int i = 0; i < itemInCart.size(); i++) {
			System.out.println(itemInCart.get(i).productCode + "     "+ itemList.get(itemInCart.get(i).productCode - 1).itemName+ "    "+ itemList.get(itemInCart.get(i).productCode - 1).itemPrice+ "     " + itemInCart.get(i).productQuantity);
		}
	}

	/*
	 * This method is used to generate bill of item in cart with total amount.
	 */
	public static void generateBill() {
		System.out.println("Code  Name  Price  Quantity");
		for (int i = 0; i < itemInCart.size(); i++) {
			System.out.println(itemInCart.get(i).productCode + "     "+ itemList.get(itemInCart.get(i).productCode - 1).itemName+ "    "+ itemList.get(itemInCart.get(i).productCode - 1).itemPrice+ "     " + itemInCart.get(i).productQuantity);
		}

		double totalAmount = 0; // Sum of all item price in cart
		for (int j = 0; j < itemInCart.size(); j++) {
			totalAmount = totalAmount + itemInCart.get(j).productQuantity * itemList.get(itemInCart.get(j).productCode - 1).itemPrice;
		}
		System.out.println("Total Amount = " + totalAmount);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		availableItem();                 
		showAvailableItem();           // For show all available Item

		Scanner in = new Scanner(System.in);

		while (true) {

			System.out
					.println("\n\n Available Options \n 1.Add\n 2.update \n 3.Display \n 4.Genrate Bill \n 5.Exit");
			System.out.println("Please Select A Option");
			int choice;

			try {                  // If choice is not Integer value
				choice = in.nextInt();
			} catch (Exception e) {
				System.out.println("Wrong Input");
				break;
			}

			switch (choice) {

			case 1:                        // For add item in cart.
				System.out.println("Please enter code for Add Item = ");
				int codeOfItem = in.nextInt();

				System.out.println("Please enter Quantity of Item = ");
				int quantityOfItem = in.nextInt();
				if (quantityOfItem > 0) {
					addToCart(codeOfItem, quantityOfItem);
				}
				break;

			case 2:                       // For update item quantity which already in cart.  
				System.out.println("Please enter code for update Item = ");
				int aCodeOfItem = in.nextInt();

				System.out.println("Please enter new quantity of Item = ");
				int aQuantityOfItem = in.nextInt();
				in.close();

				for (int i = 0; i < itemInCart.size(); i++) {
					if (aCodeOfItem == itemInCart.get(i).productCode) {
						itemInCart.get(i).productQuantity = aQuantityOfItem;
					}
				}

				break;

			case 3:                  // For Display all available item in cart.
				displayItemInCart();
				break;

			case 4:
				generateBill();      // For Generate bill with total amount.
				break;

			case 5:
				System.out.println("Exit");
				System.exit(0);
				break;

			default:
				System.out.println("Please Enter Corret Option");
			}

		}
	}

}
