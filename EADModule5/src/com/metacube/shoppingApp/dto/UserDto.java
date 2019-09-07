package com.metacube.shoppingApp.dto;

import com.metacube.shoppingApp.controller.Controller;
import com.metacube.shoppingApp.model.User;

public class UserDto {

	Controller ControllerObj ;
	
	public boolean getById(int id,String pass) {
	
		ControllerObj = Controller.getInstance();
		return  ControllerObj.getById(id, pass);
		
		
	}
}
