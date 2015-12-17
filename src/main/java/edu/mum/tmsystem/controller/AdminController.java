package edu.mum.tmsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.tmsystem.domain.Building;
import edu.mum.tmsystem.domain.DefaultCheckingSeats;
import edu.mum.tmsystem.domain.Room;
import edu.mum.tmsystem.domain.Student;
import edu.mum.tmsystem.domain.TMChecker;
import edu.mum.tmsystem.domain.User;
import edu.mum.tmsystem.enums.CheckingType;
import edu.mum.tmsystem.enums.StatusType;
import edu.mum.tmsystem.service.IBuildingService;
import edu.mum.tmsystem.service.IDefaultCheckingSeatsService;
import edu.mum.tmsystem.service.IRoomService;
import edu.mum.tmsystem.service.IStudentService;
import edu.mum.tmsystem.service.ITMCheckerService;
import edu.mum.tmsystem.service.IUserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	IBuildingService buildingService;
	@Autowired
	IRoomService roomService;
	@Autowired
	IStudentService studentService;
	@Autowired
	IUserService userService;
	@Autowired
	ITMCheckerService tmCheckerService;

	@Autowired
	IDefaultCheckingSeatsService defaultCheckingSeatsService;

	/* Home page */
	@RequestMapping(value = { "", "/", "/home" }, method = RequestMethod.GET)
	public String loadLandingPage(Model model) {
		return "admin/home";
	}

	@RequestMapping(value = { "/building", "/building/list" }, method = RequestMethod.GET)
	public String showBuildingList(Model model) {
		List<Building> buildings = buildingService.getAllBuildings();
		model.addAttribute("buildings", buildings);
		return "admin/listBuilding";
	}

	@RequestMapping(value = { "/building/add" }, method = RequestMethod.GET)
	public String addNewBuilding(@ModelAttribute("building") Building building) {
		return "admin/addBuilding";
	}

	@RequestMapping(value = { "/building/add" }, method = RequestMethod.POST)
	public String ProcessNewBuilding(
			@Valid @ModelAttribute("building") Building building,
			BindingResult bindingResult,
			RedirectAttributes redirectAtriAttributes, Model model) {
		if (bindingResult.hasErrors()) {
			return "admin/addBuilding";
		}
		buildingService.addNewBuilding(building);
		redirectAtriAttributes.addFlashAttribute("building", building);
		return "redirect:/admin/building/list";
	}

	@RequestMapping(value = { "/building/delete/{id}" }, method = RequestMethod.GET)
	public String deleteBuilding(@PathVariable("id") Integer id) {
		buildingService.deleteBuilding(id);
		return "redirect:/admin/building/list";
	}

	@RequestMapping(value = { "/room/add" }, method = RequestMethod.GET)
	public String addNewRoom(Model model) {
		List<Building> buildings = buildingService.getAllBuildings();
		model.addAttribute("buildings", buildings);
		model.addAttribute("room", new Room());
		return "admin/addRoom";
	}

	@RequestMapping(value = { "/room/add" }, method = RequestMethod.POST)
	public String ProcessNewRoom(@Valid @ModelAttribute("room") Room room,
			BindingResult bindingResult,
			RedirectAttributes redirectAtriAttributes, Model model) {
		if (bindingResult.hasErrors()) {
			List<Building> buildings = buildingService.getAllBuildings();
			model.addAttribute("buildings", buildings);
			return "admin/addRoom";
		}
		roomService.addNewRoom(room);
		return "redirect:/admin/building/list";
	}

	@RequestMapping(value = "/defaultCheckingSeats", method = RequestMethod.GET)
	public String getDefaultChekingSeats(
			@ModelAttribute("checkingSeats") DefaultCheckingSeats defaultCheckingSeats,
			Model model) {
		model.addAttribute("checking", CheckingType.values());
		return "admin/defaultCheckingSeats";

	}

	@RequestMapping(value = "/checkingseats/get_seats/{checkingType}", method = RequestMethod.GET)
	public @ResponseBody DefaultCheckingSeats getDefaultChekingSeatsByCheckingType(
			@PathVariable("checkingType") CheckingType checkingType) {
		DefaultCheckingSeats defaultCheckingSeats = defaultCheckingSeatsService
				.getDefaultCheckingSeatsByCheckingType(checkingType);
		return defaultCheckingSeats;

	}

	@RequestMapping(value = "/defaultCheckingSeats", method = RequestMethod.POST)
	public String saveDefaultChekingSeats(
			@RequestParam("checkingType") CheckingType checkingType,
			@RequestParam("numberOfSeats") Integer numberOfSeats, Model model) {
		DefaultCheckingSeats oldDefaultCheckingSeats = defaultCheckingSeatsService
				.getDefaultCheckingSeatsByCheckingType(checkingType);
		oldDefaultCheckingSeats.setNumberOfSeats(numberOfSeats);
		defaultCheckingSeatsService.saveCheckingSeats(oldDefaultCheckingSeats);
		return "redirect:/admin";

	}

	@RequestMapping(value = "/student/verify", method = RequestMethod.GET)
	public String getNewStudentList(Model model) {
		List<Student> newStudents = studentService
				.getStudentsByStatus(StatusType.INACTIVE);
		model.addAttribute("newStudents", newStudents);
		model.addAttribute("statusType", StatusType.values());
		return "admin/verifyStudents";
	}

	@RequestMapping(value = "/student/verify/{id}", method = RequestMethod.POST)
	public @ResponseBody Boolean verifyStudentList(@PathVariable("id") Long id,
			@RequestParam("status") StatusType status, Model model) {
		Student studentToVerify = studentService.getStudent(id);
		User UserToVerify = userService.getUserById(studentToVerify.getUser()
				.getId());
		UserToVerify.setStatus(status);
		System.out.println("Status" + studentToVerify.getUser().getStatus());
		userService.updateStudent(UserToVerify);
		return true;
	}

	@RequestMapping(value = { "/student", "student/list" }, method = RequestMethod.GET)
	public String getStudentList(Model model) {
		List<Student> students = studentService.getAllStudent();
		model.addAttribute("students", students);
		return "admin/listStudent";
	}

	@RequestMapping(value = "/student/delete/{id}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable("id") Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/admin/verifyStudents";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getStudent(Model model) {
		List<Student> studentList = studentService.getAllStudent();
		model.addAttribute("studentList", studentList);
		return "student/studentDetails";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String deleteStudent(@PathVariable("id") Long id,
			@ModelAttribute("studentList") Student student) {
		studentService.deleteStudentById(id);
		return "student/studentDetails";
	}

	@RequestMapping(value = { "/tmchecker/add" }, method = RequestMethod.GET)
	public String addNewTmChecker(
			@ModelAttribute("tmchecker") TMChecker tmchecker) {
		return "admin/addTMChecker";
	}

	@RequestMapping(value = { "/tmchecker/add" }, method = RequestMethod.POST)
	public String processNewTmChecker(
			@ModelAttribute("tmchecker") TMChecker tmchecker,
			BindingResult bindingResult,
			RedirectAttributes redirectAtriAttributes, Model model) {
		if (!tmchecker.getUser().getUsername().isEmpty()) {
			User dbuser = userService.getUserByUsername(tmchecker.getUser()
					.getUsername());
			if (dbuser != null) {
				ObjectError objectError = new ObjectError("user.username",
						"Username already exits");
				bindingResult.addError(objectError);
			}
		} else {
			ObjectError objectError = new ObjectError("user.username",
					"Username is required field");
			bindingResult.addError(objectError);
		}
		if (tmchecker.getUser().getPassword().isEmpty()) {
			ObjectError objectError = new ObjectError("user.password",
					"Password is required field");
			bindingResult.addError(objectError);
		}
		if (tmchecker.getUser().getEmail().isEmpty()) {
			ObjectError objectError = new ObjectError("user.email",
					"Email address is required field");
			bindingResult.addError(objectError);
		}
		if (tmchecker.getUser().getName().isEmpty()) {
			ObjectError objectError = new ObjectError("user.name",
					"Name is required field");
			bindingResult.addError(objectError);
		}

		if (bindingResult.hasErrors()) {
			return "admin/addTMChecker";
		}
		tmCheckerService.addNewTmChecker(tmchecker);
		// userService.addNewTmChecker(tmchecker.getUser());
		return "redirect:/admin/tmchecker/list";
	}

	@RequestMapping(value = { "/tmchecker", "/tmchecker/list" }, method = RequestMethod.GET)
	public String showTmCheckerList(Model model) {
		List<TMChecker> tmCheckers = tmCheckerService.getAllTmCheckers();
		model.addAttribute("tmCheckers", tmCheckers);
		return "admin/listTMChecker";
	}

	@RequestMapping(value = { "/tmchecker/disable/{id}" }, method = RequestMethod.GET)
	public String disableTmChecker(@PathVariable("id") Integer id) {
		tmCheckerService.disableTmCheckerById(id);
		return "redirect:/admin/tmchecker/list";
	}

	@RequestMapping(value = { "/tmchecker/enable/{id}" }, method = RequestMethod.GET)
	public String EnableTmChecker(@PathVariable("id") Integer id) {
		tmCheckerService.enableTmCheckerById(id);
		return "redirect:/admin/tmchecker/list";
	}

	@RequestMapping(value = { "/user", "user/list" }, method = RequestMethod.GET)
	public String getUserList(Model model) {
		List<User> users = userService.getAllUser();
		model.addAttribute("users", users);
		model.addAttribute("statusType", StatusType.values());
		return "admin/listUser";
	}

	@RequestMapping(value = "/user/changestatus/{id}", method = RequestMethod.GET)
	public String changeUserStatus(@PathVariable("id") Long id,
			@RequestParam("status") StatusType status, Model model) {
		userService.changeStatus(id, status);
		return "redirect:/admin/user/list";
	}

}
