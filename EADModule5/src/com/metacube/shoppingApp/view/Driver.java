package com.metacube.shoppingApp.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.metacube.shoppingApp.controller.Controller;
import com.metacube.shoppingApp.dto.ProductDto;
import com.metacube.shoppingApp.dto.UserDto;
import com.metacube.shoppingApp.model.CartItem;
import com.metacube.shoppingApp.model.Order;

/**
 * The Driver Class.
 */
public class Driver {

	private static Controller controllerObj;

	/**
	 * The main method.
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		String pass;
		int id;
		boolean loginStatus = false;

		Controller controllerObj;
		controllerObj = Controller.getInstance();
		Scanner sc = new Scanner(System.in);

		UserDto userDtoObj = new UserDto();
		ProductDto productDtoObj = new ProductDto();

		System.out.println("Enter the id");
		id = sc.nextInt();
		System.out.println("Enter the Pass");
		pass = sc.next();
		boolean checker = false;
		int cartId = 0;
		int orderId = 1;
		int totalPrice = 0;

		if (userDtoObj.getById(id, pass)) {
			checker = true;
			System.out.println("Login Succesfull");
		} else {
			System.out.println("Incorrect User Id or PassWord try again");
		}

		List<CartItem> cartList = new ArrayList<>();
		List<Order> orderList = new ArrayList<>();

		while (checker) {

			System.out
					.println("Select Choice [1/2/3/4] \n1- Add to cart \n2- Update Cart \n3- Display Cart \n4- placeOrder");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:

				System.out.println("Available Products  :\n");
				System.out.println("Product Id \tProduct Name");

				for (int i = 0; i < productDtoObj.getAll().size(); i++) {
					System.out.print(productDtoObj.getAll().get(i)
							.getProductId()
							+ "\t\t");
					System.out.println(productDtoObj.getAll().get(i)
							.getProductName());
				}

				System.out.println("");
				System.out.println("Choose Product Id");
				int pId = sc.nextInt();
				System.out.println("Choose Product Qty");
				int pQty = sc.nextInt();

				totalPrice = totalPrice
						+ (int) productDtoObj.getAll().get(pId - 1).getPrice()
						* pQty;
				cartList.add(new CartItem(pId, pQty, orderId));
				break;

			case 2:

				System.out.println("Available Product are:");
				System.out.println("Product Id \tProduct Name");

				for (int i = 0; i < productDtoObj.getAll().size(); i++) {
					System.out.print(productDtoObj.getAll().get(i)
							.getProductId()
							+ "\t\t");
					System.out.println(productDtoObj.getAll().get(i)
							.getProductName());
				}

				System.out.println("Choose Product Id");
				int productId = sc.nextInt();
				System.out.println("Choose Product Qty");
				int productQty = sc.nextInt();

				for (int index = 0; index < cartList.size(); index++) {

					if (productId == cartList.get(index).getProductId()) {
						cartList.get(index).setQuantity(productQty);
					}
				}
				break;

			case 3:

				for (int index = 0; index < cartList.size(); index++) {
					System.out.print(cartList.get(index).getProductId()
							+ "\t\t");
					for (int i = 0; i < productDtoObj.getAll().size(); i++) {
						if (productDtoObj.getAll().get(i).getProductId() == cartList
								.get(index).getProductId())
							System.out.print(productDtoObj.getAll().get(i)
									.getProductName()
									+ "\t\t");
					}

					System.out
							.print(cartList.get(index).getQuantity() + "\t\t");
					System.out.println();
				}
				break;

			case 4:
				Order orderObj = new Order(id, cartList.size(), totalPrice);
				for (int index = 0; index < cartList.size(); index++) {
					CartItem cartItemObj = new CartItem(cartList.get(index)
							.getProductId(), cartList.get(index).getQuantity(),
							1);

					controllerObj.add(cartItemObj);

				}

				controllerObj.add(orderObj);
				System.out.println("Succesfull place order");
				break;

			}

		}
	}
}
