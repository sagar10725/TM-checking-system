package edu.mum.tmsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.tmsystem.domain.Student;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(method = RequestMethod.GET)
	public String signUpStudent(@ModelAttribute("student") Student student) {
		return "student/signup";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student student) {
		System.out.println("Details: "+student.toString());
		return "redirect:/user";
	}

}
