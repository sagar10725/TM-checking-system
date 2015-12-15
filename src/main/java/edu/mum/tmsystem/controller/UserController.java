package edu.mum.tmsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.tmsystem.domain.Student;
import edu.mum.tmsystem.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	IUserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String signUpStudent(@ModelAttribute("student") Student student) {
		return "student/signup";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student student) {
		student.getUser().setStudent(student);
		userService.saveStudent(student.getUser());
		return "redirect:/user";
	}

}
