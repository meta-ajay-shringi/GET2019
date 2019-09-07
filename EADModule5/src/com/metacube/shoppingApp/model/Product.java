package com.metacube.shoppingApp.model;

public class Product extends BaseModel {

	private int productId;
	private String productType;
	private String productName;
	private float price;

	public Product(int productId, String productType, String productName,
			float price) {
		super();
		this.productId = productId;
		this.productType = productType;
		this.productName = productName;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
