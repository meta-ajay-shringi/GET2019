import java.util.ArrayList;
import java.util.Scanner;

/* Shoping Cart 
 * Add any available item
 * Update quantity of item
 * Display all item available in cart
 * Generat bill with total amount 
 * */
public class Cart {
	static ArrayList<Item> listCart = new ArrayList<Item>();  //All cart item save in listCart

	/* Add Item in cart 
	 * Item A in Cart
	 * */
	public static void addToCart(Item A) {
		listCart.add(A);
	}
	
	/* update quantity of item  *
	 * Item A in Cart
	 * quantity is quantity of item
	 * */
	public static void update(Item A, int quantity) {
		A.itemQuantity = quantity;
	}

	/* Display All Item in Cart  */
	public static void displayCart() {
		if(!listCart.isEmpty()) {     // Only print when Cart have Item
		   System.out.println("Available item in Cart");
		   System.out.println("Code  Name  Price Quantity ");
		   
		   for (int i = 0; i < listCart.size(); i++) {
			    System.out.println(listCart.get(i).itemCode + "   "+ listCart.get(i).itemName + "   "+ listCart.get(i).itemPrice + "   "+ listCart.get(i).itemQuantity);
		   }
	    }
		else {
			System.out.println("No Item in cart");
		}
	}	

	/* Generate Bill with total Amount  */
	public static void generatBill() {
		System.out.println("Code  Name  Price  Quantity");
		for (int i = 0; i < listCart.size(); i++) {
			
			if (listCart.get(i).itemQuantity > 0)        // display when item have at lest one quantity												
				System.out.println(listCart.get(i).itemCode + "     "+ listCart.get(i).itemName + "     "+ listCart.get(i).itemPrice + "     "+ listCart.get(i).itemQuantity);
		}

		double totalAmount = 0;    //Sum of all item price in cart
		for (int j = 0; j < listCart.size(); j++) {
			totalAmount = totalAmount + listCart.get(j).itemQuantity * listCart.get(j).itemPrice;
		}
		System.out.println("Total Amount = " + totalAmount);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
	    ArrayList<Item> itemList = new ArrayList<Item>();  // All list of item in itemList(with type Item)
		Scanner in = new Scanner(System.in);

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

		System.out.println("Item Available For You");
		System.out.println("Code  Name  Price  ");

		for (int i = 0; i < itemList.size(); i++) {
			System.out.println(itemList.get(i).itemCode + "     "+ itemList.get(i).itemName + "    "+ itemList.get(i).itemPrice);
		}

		while (true) {
			System.out.println("\n\n Available Options \n 1.Add\n 2.update \n 3.Display \n 4.Genrate Bill \n 5.Exit");
			System.out.println("Please Select A Option");
			int choice = 0;
			
			try {      // If choice is not Integer value
			  choice = in.nextInt();
			}
			catch(Exception e) {
				System.out.println("Wrong Input");
				break;
			}
			
			// switch case for all avaliable option
			
			switch (choice) {
			case 1:                            //for Add item in Cart
				System.out.println("Please enter code for Add Item = ");
				int codeOfItem = in.nextInt();

				System.out.println("Please enter Quantity of Item = ");
				int quantityOfItem = in.nextInt();

				if (quantityOfItem > 0) {

					for (int i = 0; i < itemList.size(); i++) {
						if (codeOfItem == itemList.get(i).itemCode) {
							itemList.get(i).itemQuantity = quantityOfItem;
							addToCart(itemList.get(i));
						}
					}
				}
				break;

			case 2:                           //Update Quantity of Item which available in cart
				System.out.println("Please enter code for update Item = ");
				int AcodeOfItem = in.nextInt(); // Input a code 
				System.out.println("Please enter Quantity of Item = ");
				int AquantityOfItem = in.nextInt();
				 in.close();
				 if(AquantityOfItem > 0) {
				     for (int i = 0; i < itemList.size(); i++) {
	    
					       if (AcodeOfItem == itemList.get(i).itemCode) {
						       itemList.get(i).itemQuantity = AquantityOfItem;
						       update(itemList.get(i), AquantityOfItem);
					        }
				    }
				 }
				break;

			case 3:                           //Display available item in cart
				displayCart();
				break;

			case 4:                          //Display Total amount of bill
				generatBill();
				break;

			case 5:                          // Exit
				System.out.println("Exit");
				System.exit(0);
				break;

			default:
				System.out.println("Please Enter Corret Option");
			}
	  }
  }
}
