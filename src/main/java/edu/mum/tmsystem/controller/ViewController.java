package edu.mum.tmsystem.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.tmsystem.domain.Student;
import edu.mum.tmsystem.domain.User;
import edu.mum.tmsystem.enums.RoleType;
import edu.mum.tmsystem.service.IStudentService;
import edu.mum.tmsystem.service.IUserService;
import edu.mum.tmsystem.util.SessionManager;
import edu.mum.tmsystem.util.Utility;

@Controller
public class ViewController {
	
	@Autowired
	IUserService userService;

	@Autowired
	IStudentService studentService;

	private static Logger logger = Logger.getLogger(ViewController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loadFirstPage() {
//		if (Utility.getLoggedInUserName() != null) {
//			logger.info("User already logged in:" + Utility.getLoggedInUserName());
//			return "redirect:/home";
//		}
//		logger.info("Retriving login page");
//		return "redirect:/login";
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginSignUpPage() {
		if (Utility.getLoggedInUserName() != null) {
			logger.info("User already logged in:" + Utility.getLoggedInUserName());
			return "redirect:/home";
		}
		logger.info("Retriving login page");
		return "login";
	}
	
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
 
		model.addAttribute("error", "true");
		return "login";
 
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String welcomePage() {
		if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null
				&& !SessionManager.isAnonymousUser()) {
			if (SessionManager.getRole().contains(RoleType.ROLE_ADMIN)) {
				return "redirect:/admin";
			} else if (SessionManager.getRole().contains(RoleType.ROLE_TMCHECKER)) {
				return "redirect:/tmchecker";
			} else if (SessionManager.getRole().contains(RoleType.ROLE_STUDENT)) {
				return "redirect:/student";
			}else{
				return "home";
			}
		}
		//return "redirect:/login";
		return "home";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "redirect:/";
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String accessdeniedPage() {
		return "accessdenied";
	}
	
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String signUpStudent(@ModelAttribute("student") Student student) {
		return "student/signup";
	}

	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
		User dbuser =userService.getUserByUsername(student.getUser().getUsername());
		Student dbStudent = studentService.getStudentByStudentID(student.getStudentId());
		if(dbuser != null || dbStudent != null){
			if(dbuser != null){
				ObjectError objectError = new ObjectError("student",
						"Username already exits");
				result.addError(objectError);
			}
			if(dbStudent != null){
				ObjectError objectError = new ObjectError("student",
						"Student ID already exits");
				result.addError(objectError);
			}
		}
		if (result.hasErrors()) {
			return "student/signup";
		}
		
		student.getUser().setStudent(student);
		userService.saveStudent(student.getUser());
		return "redirect:/home";
	}

}
