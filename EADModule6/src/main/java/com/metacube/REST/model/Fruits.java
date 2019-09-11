package com.metacube.REST.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Model class for fruit(POJO).
 */
@XmlRootElement
public class Fruits extends BaseModel {

	private String fruitName;
	private int quantity;

	public Fruits(String fruitName, int quantity) {
		this.fruitName = fruitName;
		this.quantity = quantity;
	}

	public Fruits() {
		super();
	}

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
