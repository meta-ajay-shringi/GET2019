/**
 * 
 */
package com.metacube.EADSession9.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.EADSession9.dao.ApplicationDAO;
import com.metacube.EADSession9.model.EmployeeCommands;
import com.metacube.EADSession9.model.EmployeeInfo;
import com.metacube.EADSession9.model.ProfileCommands;

/**
 * This class used to implement all the busniess logic of the application 
 */
@Service
public class ApplicationService{
	
	@Autowired
	ApplicationDAO applicationDAO;

	public boolean addEmployee(EmployeeCommands emp) {
		return applicationDAO.addEmployee(emp);
	}

	
	public boolean update(EmployeeCommands emp) {
		return applicationDAO.update(emp);
	}

	
	public List<String> getFriends(String email) {
		
		return applicationDAO.getFriends(email);
	}

	
	public EmployeeCommands getEmployeeByEmail(String email) {
		return applicationDAO.getEmployee(email);
	}

	
	public ProfileCommands getProfile(String email) {
		return applicationDAO.getProfile(email);
	}

	public EmployeeInfo getEmpoyeeInfo(String email, String password) {
		EmployeeInfo info = applicationDAO.getEmpoyeeInfo(email, password);
		if(info!=null && info.getImage()==null){
			info.setImage("parking.png");
		}
		return info; 
	}

	public boolean uploadPhoto(String email,String imgName, String existImgName){
		if(!existImgName.equals("parking.png")){
			return applicationDAO.updateUploadPhoto(email, imgName);
		}else{
			return applicationDAO.uploadPhoto(email, imgName);
		}
		
	}

	public boolean addVehicle(int empId, String name, String type,
			String vehicleNumber, String identification) {
		return applicationDAO.addVehicle(empId,name,type,vehicleNumber,identification);
	}

	public boolean addPlan(int empId, String vehicleNumber, String plan,
			double price) {
		return applicationDAO.addPlan(empId,vehicleNumber,plan,price);
	}

}
