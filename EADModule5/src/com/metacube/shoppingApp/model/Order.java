package com.metacube.shoppingApp.model;

public class Order extends BaseModel {

	private int userId;
	private int totalCartItem;
	private float totalPrice;

	public Order(int userId, int totalCartItem, float totalPrice) {
		super();
		this.userId = userId;
		this.totalCartItem = totalCartItem;
		this.totalPrice = totalPrice;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTotalCartItem() {
		return totalCartItem;
	}

	public void setTotalCartItem(int totalCartItem) {
		this.totalCartItem = totalCartItem;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

}
