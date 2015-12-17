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
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String signUpStudent(@ModelAttribute("student") Student student) {
		return "student/signup";
	}

	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "student/signup";
		}
		student.getUser().setStudent(student);
		userService.saveStudent(student.getUser());
		return "redirect:/home";
	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	public String changePassword(Model model) {

		return "user/changepassword";
	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	public String savenewPassword(@RequestParam("oldpassword") String oldpassword,
			@RequestParam("newpassword") String newpassword, @RequestParam("confirmpassword") String confirmpassword) {
		if (!userService.changePassword(oldpassword, newpassword, confirmpassword)) {
			return "user/changepassword";
		}
		return "user/successfulpage";
	}

	@RequestMapping(value = "/userProfile", method = RequestMethod.GET)
	public String getUserProfile(User user, Model model) {
		// System.out.println("User ID:" + SessionManager.getUserID());
		user = userService.getUserProfileById(SessionManager.getUserID());
		model.addAttribute("user", user);
		return "user/userDetails";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editUser(User user, Model model) {
		// System.out.println("=============================");
		// System.out.println("User ID:" + SessionManager.getUserID());
		user = userService.getUserProfileById(SessionManager.getUserID());
		model.addAttribute("user", user);
		return "user/userEdit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String updateUser(@Valid User updateUser, BindingResult result, Model model, HttpServletRequest request,
			HttpServletResponse response) {

		if (result.hasErrors()) {
			System.out.println("error in file update");
			return "user/userEdit";
		}
		updateUser.setId(SessionManager.getUserID());

		MultipartFile profileImage = updateUser.getProfileImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		/*
		 * System.out.println(profileImage.getOriginalFilename()); String
		 * fullPath = "resources"+ File.separator +"images" + File.separator +
		 * updateUser.getId() + ".png";
		 */
		String fullPath = "\\resources\\images\\" + updateUser.getId() + ".png";

		try {
			profileImage.transferTo(new File(fullPath));
		} catch (Exception e) {
			throw new RuntimeException("Product Image saving failed", e);
		}

		updateUser.setImagePath(fullPath);
		userService.updateUser(updateUser);
		return "redirect:/user/userProfile";
	}

}
