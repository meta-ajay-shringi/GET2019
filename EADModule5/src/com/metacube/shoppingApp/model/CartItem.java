package com.metacube.shoppingApp.model;

public class CartItem extends BaseModel {

	private int productId;
	private int quantity;
	private int orderId;

	public CartItem(int productId, int quantity, int orderId) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

}
