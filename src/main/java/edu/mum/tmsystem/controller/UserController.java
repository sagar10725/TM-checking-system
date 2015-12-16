package edu.mum.tmsystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.tmsystem.domain.Student;
import edu.mum.tmsystem.domain.User;
import edu.mum.tmsystem.service.IUserService;
import edu.mum.tmsystem.util.Utility;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	IUserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String signUpStudent( @ModelAttribute("student") Student student) {
		return "student/signup";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult result,Model model) {
		
		if(result.hasErrors()){
			return "student/signup";
		}
		student.getUser().setStudent(student);
		userService.saveStudent(student.getUser());
		return "redirect:/user";
	}
	
	@RequestMapping(value= "/changepassword",  method=RequestMethod.GET)
	public String changePassword(Model model){
		
		return "user/changepassword";
	}
	
	@RequestMapping(value= "/changepassword",  method=RequestMethod.POST)
	public String savenewPassword(@Valid @ModelAttribute("passwordchange") User user,@RequestParam("oldpassword") String oldpassword, @RequestParam("newpassword")
	String newpassword, @RequestParam("confirmpassword") String confirmpassword){
		
			if(!userService.changePassword(oldpassword,newpassword,confirmpassword)){
	    			return "user/changepassword";
	    		}
	    	
	    	
		return "user/successfulpage";
	}
	
	
}
