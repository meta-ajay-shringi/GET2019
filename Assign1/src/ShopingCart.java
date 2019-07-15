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
	 * This method is used to save item in itemList.
	 */
	public static void availableItem() {
		Item ball = new Item(1, "Ball", 80.00);
		itemList.add(ball);

		Item shoes = new Item(2, "Shoes", 1200.00);
		itemList.add(shoes);

		Item bat = new Item(3, "Bat", 700.00);
		itemList.add(bat);

		Item cap = new Item(4, "Cap", 100.00);
		itemList.add(cap);

		Item cup = new Item(5, "Cup", 50.00);
		itemList.add(cup);
	}

	/*
	 * This methord is used to show all available item.
	 */
	public static void showAvailableItem() {
		System.out.println("Item Available For You");
		System.out.println("Code  Name  Price  ");

		for (int index = 0; index < itemList.size(); index++) {
			System.out.println(itemList.get(index).itemCode + "     " + itemList.get(index).itemName + "    " + itemList.get(index).itemPrice);
		}
	}

	/*
	 * This method is used to add item in cart
	 * @param code This is code of item.
	 * @param quentity This is quentity of item.
	 */
	public static void addToCart(int code, int quentity) {
		for (int index = 0; index < itemInCart.size(); index++) {
			if (code == itemInCart.get(index).productCode) {
				System.out.println("This Item already in Cart , Please go to update if you want to change quantity of Item");
				return;
			}
		}

		Cart aItem = new Cart();
		aItem.productCode = code;
		aItem.productQuantity = quentity;
		itemInCart.add(aItem);
	}

	/*
	 * This method is used to update quantity of item which already in cart.
	 * @param CodeOfItem This isItem code which quantity going to update.
	 * @param QuantityOfItem This is new quantity of item.
	 */
	public static void update(int codeOfItem, int quantityOfItem)
			throws InvalidUpdateException {
		if (quantityOfItem <= 0) {
			throw new InvalidUpdateException(
					"Quantity can't be negative or 0, Please go again on update option ");
		} else {
			for (int index = 0; index < itemInCart.size(); index++) {
				if (codeOfItem == itemInCart.get(index).productCode) {
					itemInCart.get(index).productQuantity = quantityOfItem;
				}
			}
		}

	}

	/*
	 * This method used to show all available item in cart with item code,
	 * name,price , quantity.
	 */
	public static void displayItemInCart() {
		System.out.println("Code  Name  Price  Quantity");
		for (int index = 0; index < itemInCart.size(); index++) {
			System.out.println(itemInCart.get(index).productCode + "     " + itemList.get(itemInCart.get(index).productCode - 1).itemName + "    " + itemList.get(itemInCart.get(index).productCode - 1).itemPrice + "     " + itemInCart.get(index).productQuantity);
		}
	}

	/*
	 * This method is used to generate bill of item in cart with total amount.
	 */
	public static void generateBill() {
		System.out.println("Code  Name  Price  Quantity");
		for (int index = 0; index < itemInCart.size(); index++) {
			System.out.println(itemInCart.get(index).productCode + "     " + itemList.get(itemInCart.get(index).productCode - 1).itemName + "    " + itemList.get(itemInCart.get(index).productCode - 1).itemPrice + "     " + itemInCart.get(index).productQuantity);
		}

		double totalAmount = 0; // Sum of all item price in cart
		for (int index = 0; index < itemInCart.size(); index++) {
			totalAmount = totalAmount + itemInCart.get(index).productQuantity * itemList.get(itemInCart.get(index).productCode - 1).itemPrice;
		}
		System.out.println("Total Amount = " + totalAmount);

	}

	public static void main(String[] args) {

		availableItem();
		showAvailableItem(); // For show all available Item

		Scanner in = new Scanner(System.in);

		while (true) {

			System.out
					.println("\n\n Available Options \n 1.Add\n 2.update \n 3.Display \n 4.Genrate Bill \n 5.Exit");
			System.out.println("Please Select A Option");
			int choice;

			try {                // If choice is not Integer value
				choice = in.nextInt();
			} catch (Exception e) {
				System.out.println("Wrong Input");
				break;
			}

			switch (choice) {

			case 1:                // For add item in cart.
				System.out.println("Please enter code for Add Item = ");
				int codeOfItem = in.nextInt();

				System.out.println("Please enter Quantity of Item = ");
				int quantityOfItem = in.nextInt();

				if (quantityOfItem <= 0) {
					System.out.println("Please enter again valid quantity");
					quantityOfItem = in.nextInt();
					addToCart(codeOfItem, quantityOfItem);
				} else {

					addToCart(codeOfItem, quantityOfItem);
				}
				break;

			case 2:              // For update item quantity which already in cart.
				System.out.println("Please enter code for update Item = ");
				int codeOfNewItem = in.nextInt();

				System.out.println("Please enter new quantity of Item = ");
				int quantityOfNewItem = in.nextInt();

				try {
					update(codeOfNewItem, quantityOfNewItem);
				} catch (InvalidUpdateException e) {
					System.out.println(e.getMessage());
				}

				break;

			case 3:                // For Display all available item in cart.
				displayItemInCart();
				break;

			case 4:
				generateBill();       // For Generate bill with total amount.
				break;

			case 5:
				System.out.println("Exit");
				System.exit(0);
				break;

			default:
				System.out.println("Please Enter Corret Option");
			}

		}
		in.close();
	}

}
