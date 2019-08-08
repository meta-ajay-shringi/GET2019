package question1;

import java.util.Scanner;

/**
 * This is main class.
 */
public class MainDrive {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		JsonRead jasonRead = new JsonRead();
		bst.root = jasonRead.Json("KeyValue.json");
		Scanner in = new Scanner(System.in);

		int choice;

		
		while (true) {
			System.out.println(" 1. Insert \n 2. Remove \n 3. Get Value of a key \n 4. Print in sorted Order \n 5. Print in sorted from range \n 6.Exit");
			System.out.println(" Please select a choice ");

			choice = in.nextInt();

			switch (choice) {

			case 1:

				System.out.println("Please enter key ");
				int key = in.nextInt();
				System.out.println("Please enter value ");
				in.nextLine();
				String value = in.nextLine();
				KeyValuePair keyValue = new KeyValuePair(key, value);
				bst.insert(keyValue);
				break;

			case 2:
				System.out.println("Please enter key ");
				int keyForRemove = in.nextInt();
				System.out.println("Please enter value ");
				in.nextLine();
				String valueForRemove = in.nextLine();
				KeyValuePair keyValueForRemove = new KeyValuePair(keyForRemove, valueForRemove);
				bst.root = bst.remove(keyValueForRemove);
				break;

			case 3:
				System.out.println("Please enter key ");
				int keyForFind = in.nextInt();
				String valueForFind = bst.getValue(keyForFind);
				System.out.println("value of key " + keyForFind + ": " + valueForFind);
				break;

			case 4:
				System.out.println("Sorted list of key value pair is ");
				bst.sortedList(bst.root);
				for (int index = 0; index < bst.list.size(); index++) {
					System.out.println(bst.list.get(index).key + "  " + bst.list.get(index).value);
				}
				break;

			case 5:
				System.out.print("Please enter range from ");
				int k1 = in.nextInt();
				System.out.println(" to ");
				int k2 = in.nextInt();
				bst.sortedListRange(bst.root, k1, k2);
				System.out.println("Sorted list from " + k1 + " to " + k2);
				for (int index = 0; index < bst.listRange.size(); index++) {
					System.out.println(bst.listRange.get(index).key + "  " + bst.listRange.get(index).value);
				}
				break;

			case 6:
				System.out.println("EXIT");
				System.exit(0);
				

			default:
				System.out.println(" Invalid input ");
				break;
			}
		}

	}

}
