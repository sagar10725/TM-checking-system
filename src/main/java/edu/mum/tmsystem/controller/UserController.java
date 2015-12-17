package edu.mum.tmsystem.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import edu.mum.tmsystem.domain.Student;
import edu.mum.tmsystem.domain.User;
import edu.mum.tmsystem.exception.dto.ChangePasswordDTO;
import edu.mum.tmsystem.service.IStudentService;
import edu.mum.tmsystem.service.IUserService;
import edu.mum.tmsystem.util.SessionManager;
import edu.mum.tmsystem.util.Utility;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	IUserService userService;

	@Autowired
	IStudentService studentService;

	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	public String changePassword(Model model) {
		model.addAttribute("passwordchange", new ChangePasswordDTO());
		return "user/changepassword";
	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	public String savenewPassword(@Valid @ModelAttribute("passwordchange") ChangePasswordDTO changePasswordDTO, BindingResult result) {
		if(result.hasErrors()){
			return "user/changepassword";
		}
		if (!userService.changePassword(changePasswordDTO.getOldpassword(), changePasswordDTO.getNewpassword(), changePasswordDTO.getConfirmpassword())) {
			ObjectError objectError = new ObjectError("error",
					"Invalid Password");
			result.addError(objectError);
			return "user/changepassword";
		}
		return "redirect:/home";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
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
	public String updateUser(User updateUser, BindingResult result, Model model, HttpServletRequest request,
			HttpServletResponse response) {
		Student dbStudent = studentService.getStudentByStudentID(updateUser.getStudent().getStudentId());
		if(dbStudent != null){
			if(!dbStudent.getUser().getId().equals(SessionManager.getUserID())){
				ObjectError objectError = new ObjectError("student",
						"Student ID already exits");
				result.addError(objectError);
			}
		}
		if (result.hasErrors()) {
			return "user/userEdit";
		}
		updateUser.setId(SessionManager.getUserID());

		MultipartFile profileImage = updateUser.getProfileImage();
		File uploadDir = new File(Utility.IMAGE_UPLOAD_PATH);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		String fullPath = updateUser.getId() + ".png";

		try {
			profileImage.transferTo(new File(Utility.IMAGE_UPLOAD_PATH + fullPath));
		} catch (Exception e) {
			throw new RuntimeException("Profile Image saving failed", e);
		}

		updateUser.setImagePath(fullPath);
		userService.updateUser(updateUser);
		return "redirect:/user/profile";
	}

}
