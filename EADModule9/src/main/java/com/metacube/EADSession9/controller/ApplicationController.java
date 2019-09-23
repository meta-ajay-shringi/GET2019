package com.metacube.EADSession9.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.metacube.EADSession9.model.EmployeeCommands;
import com.metacube.EADSession9.model.EmployeeInfo;
import com.metacube.EADSession9.model.ProfileCommands;
import com.metacube.EADSession9.service.ApplicationService;
import com.metacube.EADSession9.service.DecodePass;
/**
 * This is Controller class of Application Every Request of application will be handle here
 */
@Controller
public class ApplicationController {
	
	@Autowired
	ApplicationService service;
	
	//for getting home page
	@GetMapping("/home")
	public String home(){
		return "home";
	}
	
	//redirects to Login page after login request
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	
	//Post method for login
	@PostMapping("/login")
	public String loggedIn(@RequestParam String email, @RequestParam String password,HttpSession session,Model model){
		EmployeeInfo info = service.getEmpoyeeInfo(email, password);
		
		if(info == null){
			model.addAttribute("msg","Incorrect credentials");
			return "login";
		}else{
			session.setAttribute("email", info.getEmail());
			session.setAttribute("image", info.getImage());
			model.addAttribute("empId", info.getEmpId());
			if(info.getVehicleNumber()== null){//first time or not check
				return "vehicleForm";
			}else{	
				return "home";
			}
		}
		
		
	}
	
	//Register page and Register a Employee
	@GetMapping("/register")
	public String registerPage(Model model){
		model.addAttribute(new EmployeeCommands());
		return "register";
	}
	
	//Post method for registering employee
	@PostMapping("/register")
	public String doRegister(@Validated EmployeeCommands emp, BindingResult result,Model model){
		System.out.println(emp.toString());
		if(result.hasErrors()){
			return "register";
		}else{
			if(!emp.getPassword().equals(emp.getConfirmPassword())){
				ObjectError objectError = new ObjectError("name","Password is not Matching");
				result.addError(objectError);
				return "register";
			}else{//All validated
				if(service.getEmployeeByEmail(emp.getEmail())==null){
					service.addEmployee(emp);
					model.addAttribute("msg","Employee added successfully , please log in");
					return "login";
				}else{
					ObjectError objectError = new ObjectError("email","Email Id already exists");
					result.addError(objectError);
					return "register";
				}
				
			}
		}
		
	} 
	
	//redirects to Edit Profile page
	@GetMapping("/editUserProfile")
	public String edit(EmployeeCommands emp, Model model, HttpSession session){
		emp = service.getEmployeeByEmail((String)session.getAttribute("email"));
		if(emp==null)
			return "login";
		model.addAttribute(emp);
		return "editProfile";
	}
	
	//Post method for edit profile
	@PostMapping("/editUserProfile")
	public String doEdit(@Validated EmployeeCommands emp, BindingResult result){
		if(result.hasErrors()){
			return "editProfile";
		}else{
			if(!emp.getPassword().equals(emp.getConfirmPassword())){
				ObjectError objectError = new ObjectError("name","Password is not Matching");
				result.addError(objectError);
				return "editProfile";
			}else{
				if(service.update(emp)){
					System.out.println("Updated");
				}else{
					System.out.println("Error while updating");
				}
				return "home";
			}
		}
	}
	
	//Vehicle Form submitted
	@PostMapping("/vehicleRegister")
	public String vehicleDetails(@RequestParam String vname, @RequestParam String vtype ,
			@RequestParam String vnumber, @RequestParam String empId, @RequestParam String price,@RequestParam String identification, DecodePass decode){
		if(service.addVehicle(Integer.parseInt(empId.trim()), vname, vtype, vnumber, identification) &&
				service.addPlan(Integer.parseInt(empId.trim()), vnumber, decode.plan(price),decode.price(price) )){
			System.out.println("Succesfully Added");
			return "home";
		}else{
			System.out.println("here");
			return "home";
		}
		
	}
	
	//for see Profile
	@GetMapping("/viewProfile")
	public String viewProfile(@RequestParam String email,Model model, HttpSession session){
			
		if(email.equals("null")){
			System.out.println("hello");
			email = (String)session.getAttribute("email");
			
		}
		
		if(email==null)
			return "login";
		
	
		model.addAttribute("profile", service.getProfile(email));
		return "viewProfile";
	}
	
	//To display friends
	@GetMapping("/friends")
	public String friends(Model model,HttpSession session){
		
		String email = (String)session.getAttribute("email");
	
		if(email==null)
			return "login";
	
		model.addAttribute("list", service.getFriends((String)session.getAttribute("email")));
		return "friends";
	}
	
	//redirects to form for uploading photo
	@GetMapping("/uploadPhoto")
	public String uploadPhoto(){
		return "uploadPhoto";
	}
	
	//Submitting photo
	@PostMapping("/uploadPhoto")
	public String doUploadPhoto(@RequestParam("file") MultipartFile file, HttpSession session){
		 byte[] bytes;
		try {
			bytes = file.getBytes();
			System.out.println(bytes);
			Path path = Paths.get("C://Users//Ajay//Desktop//Spring Boot//EAD-Session10//src//main//resources//images//" + file.getOriginalFilename());
	        Files.write(path, bytes);
	        if(service.uploadPhoto((String)session.getAttribute("email"),file.getOriginalFilename(),(String)session.getAttribute("image"))){
	        	System.out.println("Image Successfully Added");
	        	session.setAttribute("image", file.getOriginalFilename());
	        }else{
	        	System.out.println("Error: in adding image");
	        }
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
		return "redirect:home";
	}
	
	@GetMapping("/logout")
	public String logOut(HttpSession session){
		session.invalidate();
		return "home";
	}
}
