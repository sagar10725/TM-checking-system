package edu.mum.tmsystem.controller;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.tmsystem.domain.Building;
import edu.mum.tmsystem.domain.DefaultCheckingSeats;
import edu.mum.tmsystem.domain.Room;
import edu.mum.tmsystem.enums.CheckingType;
import edu.mum.tmsystem.service.IBuildingService;
import edu.mum.tmsystem.service.IDefaultCheckingSeatsService;
import edu.mum.tmsystem.service.IRoomService;

@Controller
@RequestMapping("/admin")
@SessionAttributes("rooms")
public class AdminController {

	@Autowired
	IBuildingService buildingService;
	@Autowired
	IRoomService roomService;
	
	@Autowired
	IDefaultCheckingSeatsService defaultCheckingSeatsService;

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
}
