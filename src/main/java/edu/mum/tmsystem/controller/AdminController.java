package edu.mum.tmsystem.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.tmsystem.domain.Building;
import edu.mum.tmsystem.domain.DefaultCheckingSeats;
import edu.mum.tmsystem.domain.Room;
import edu.mum.tmsystem.domain.Student;
import edu.mum.tmsystem.domain.User;
import edu.mum.tmsystem.enums.CheckingType;
import edu.mum.tmsystem.enums.StatusType;
import edu.mum.tmsystem.service.IBuildingService;
import edu.mum.tmsystem.service.IDefaultCheckingSeatsService;
import edu.mum.tmsystem.service.IRoomService;
import edu.mum.tmsystem.service.IStudentService;
import edu.mum.tmsystem.service.IUserService;

@Controller
@RequestMapping("/admin")
@SessionAttributes("rooms")
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
	IDefaultCheckingSeatsService defaultCheckingSeatsService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String loadLandingPage(Model model) {
		return "admin/home";
	}
	
	@RequestMapping(value = { "/building", "/building/list" }, method = RequestMethod.GET)
	public String showBuildingList(Model model) {
		List<Building> buildings = buildingService.getAllBuildings();
		model.addAttribute("buildings", buildings);
		return "building/listBuilding";
	}

	@RequestMapping(value = { "/building/add" }, method = RequestMethod.GET)
	public String addNewBuilding(@ModelAttribute("building") Building building) {
		return "building/addBuilding";
	}

	@RequestMapping(value = { "/building/delete/{id}" }, method = RequestMethod.GET)
	public String deleteBuilding(@PathVariable("id") Integer id) {
		buildingService.deleteBuilding(id);
		return "redirect:/admin/building/list";
	}
	
	@RequestMapping(value = { "/building/add" }, method = RequestMethod.POST)
	public String ProcessNewBuilding(
			@Valid @ModelAttribute("building") Building building,
			BindingResult bindingResult,
			RedirectAttributes redirectAtriAttributes, Model model) {
		if (bindingResult.hasErrors()) {
			return "building/addBuilding";
		}
		buildingService.addNewBuilding(building);
		redirectAtriAttributes.addFlashAttribute("building", building);
		return "redirect:/admin/building/list";
	}
	
	@RequestMapping(value = { "/room/add" }, method = RequestMethod.GET)
	public String addNewRoom(Model model) {		
		List<Building> buildings = buildingService.getAllBuildings();
		model.addAttribute("buildings", buildings);
		model.addAttribute("room", new Room());
		return "room/addRoom";
	}

	@RequestMapping(value = { "/room/add" }, method = RequestMethod.POST)
	public String ProcessNewRoom(
			@Valid @ModelAttribute("room") Room room,
			BindingResult bindingResult,
			RedirectAttributes redirectAtriAttributes, Model model) {
		if (bindingResult.hasErrors()) {
			return "room/addRoom";
		}
//		Building building = buildingService.getBuildingOne(room.getBuilding().getId());
//		building.getRooms().add(room);
//		buildingService.addNewBuilding(building);
		roomService.addNewRoom(room);
		return "redirect:/admin/building/list";
	}
	
	@ModelAttribute("checking")
	public CheckingType[] checkingType(){
		return CheckingType.values();
	}
	@RequestMapping(value = "/defaultCheckingSeats", method = RequestMethod.GET)
	public String getDefaultChekingSeats(@ModelAttribute("checkingSeats") DefaultCheckingSeats defaultCheckingSeats) {
		return "student/defaultCheckingSeats";

	}

	@RequestMapping(value = "/defaultCheckingSeats", method = RequestMethod.POST)
	public String saveDefaultChekingSeats(@ModelAttribute("checkingSeats") DefaultCheckingSeats defaultCheckingSeats) {
		
		defaultCheckingSeatsService.saveCheckingSeats(defaultCheckingSeats);
		return "student/defaultCheckingSeats";

	}
	
	@RequestMapping(value="/verifyStudents", method=RequestMethod.GET)
	public String getStudentList(Model model){
		List<Student> newStudents = studentService.getStudentsByStatus(StatusType.INACTIVE);
		model.addAttribute("newStudents", newStudents);
		model.addAttribute("statusType", StatusType.values());
		return "admin/verifyStudents";
	}
	
	@RequestMapping(value="/verifyStudents/{id}", method=RequestMethod.POST)
//	public String verifyStudentList(@PathVariable("id") Long id, @RequestParam("status") StatusType status, Model model){
	public @ResponseBody void verifyStudentList(@PathVariable("id") Long id, @RequestParam("status") StatusType status, Model model){
		Student studentToVerify = studentService.getStudent(id);
		User UserToVerify = userService.getUserById(studentToVerify.getUser().getId());
		UserToVerify.setStatus(status);
		System.out.println("Status" + studentToVerify.getUser().getStatus());
		userService.updateStudent(UserToVerify);
		return;
	}
	
	@RequestMapping(value = "/student/delete/{id}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable("id") Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/admin/verifyStudents";
	}
}
