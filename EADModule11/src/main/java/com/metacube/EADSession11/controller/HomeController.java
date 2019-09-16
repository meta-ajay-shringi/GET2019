package com.metacube.EADSession11.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.EADSession11.model.StudentInfo;
import com.metacube.EADSession11.service.BaseService;
import com.metacube.EADSession11.service.StudentService;

/**
 * Controller class.
 */
@Controller
public class HomeController {

	List<StudentInfo> studentList = new ArrayList<>();

	@Autowired
	private StudentService studentServiceObj;

	// message get data from application.yml file.
	@Value("${message}")
	public String message;

	/*
	 * this mapped to homepage.
	 */
	@GetMapping("/Homepage")
	public String homepage(Model model) {
		model.addAttribute("message", message);
		return "Homepage";
	}

	/*
	 * this mapped to studentDetails.
	 */
	@GetMapping("/StudentDetails")
	public String studentDetails(Model model) {
		model.addAttribute("studentInfo", new StudentInfo());
		return "StudentDetails";
	}

	/*
	 * postmapping to studentDetails
	 */
	@PostMapping("/StudentDetails")
	public String doStudentDetail(@Validated StudentInfo student,
			BindingResult result, Model model) {

		if (result.hasErrors()) {

		} else {
			model.addAttribute("result", "data Successfully added");
			studentServiceObj.add(student);
			System.out.println(student);
		}

		return "StudentDetails";

	}

	/*
	 * this mapped to showStudent.
	 */
	@GetMapping("/ShowStudent")
	public String showStudent(Model model) {

		studentList = studentServiceObj.getAll();
		model.addAttribute("studentList", studentList);
		return "ShowStudent";
	}

}
