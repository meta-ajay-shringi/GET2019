package com.metacube.shoppingApp.dto;

import java.util.List;

import com.metacube.shoppingApp.controller.Controller;
import com.metacube.shoppingApp.model.Product;

public class ProductDto {

	
	Controller ControllerObj ;
	
	public List<Product> getAll() {
		ControllerObj = Controller.getInstance();
		return ControllerObj.getAll();
	}
	
}
