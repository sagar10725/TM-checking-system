package edu.mum.tmsystem.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import edu.mum.tmsystem.domain.Student;
import edu.mum.tmsystem.domain.User;
import edu.mum.tmsystem.service.IUserService;
import edu.mum.tmsystem.util.SessionManager;

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

	@RequestMapping(value = "/userProfile", method = RequestMethod.GET)
	public String getUserProfile(User user, Model model) {
		// System.out.println("User ID:" + SessionManager.getUserID());
		user = userService.getUserProfileById(SessionManager.getUserID());
		model.addAttribute("user", user);
		return "student/userDetails";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editUser(User user, Model model) {
		// System.out.println("=============================");
		// System.out.println("User ID:" + SessionManager.getUserID());
		user = userService.getUserProfileById(SessionManager.getUserID());
		model.addAttribute("user", user);
		return "student/userEdit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String updateUser(@Valid User updateUser, BindingResult result, Model model, HttpServletRequest request,
			HttpServletResponse response) {

		if (result.hasErrors()) {
			System.out.println("error in file update");
			return "student/userEdit";
		}
		updateUser.setId(SessionManager.getUserID());
		
		MultipartFile profileImage = updateUser.getProfileImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		System.out.println(profileImage.getOriginalFilename());
		String fullPath = rootDirectory + File.separator+"resources"+ File.separator +"image" + updateUser.getId() + ".png";
		try {
			profileImage
					.transferTo(new File(fullPath));
		} catch (Exception e) {
			throw new RuntimeException("Product Image saving failed", e);
		}
		
		updateUser.setImagePath(fullPath);
		userService.updateUser(updateUser);
		return "redirect:userProfile";
	}

}
