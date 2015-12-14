package edu.mum.tmsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.tmsystem.domain.Building;
import edu.mum.tmsystem.domain.Room;
import edu.mum.tmsystem.service.IBuildingService;
import edu.mum.tmsystem.service.IRoomService;

@Controller
@RequestMapping("/admin")
@SessionAttributes("rooms")
public class AdminController {

	@Autowired
	IBuildingService buildingService;
	@Autowired
	IRoomService roomService;

	@RequestMapping(value = { "/building", "/building/list" }, method = RequestMethod.GET)
	public String showBuildingList(Model model) {
		List<Building> buildings = buildingService.getAllBuildings();
		model.addAttribute("buildings", buildings);
		return "building/list";
	}

	@RequestMapping(value = { "/building/add" }, method = RequestMethod.GET)
	public String addNewBuilding(@ModelAttribute("building") Building building) {
		return "building/add";
	}

	@RequestMapping(value = { "/building/add" }, method = RequestMethod.POST)
	public String ProcessNewBuilding(
			@Valid @ModelAttribute("building") Building building,
			BindingResult bindingResult,
			RedirectAttributes redirectAtriAttributes, Model model) {
		if (bindingResult.hasErrors()) {
			return "building/add";
		}
		buildingService.addNewBuilding(building);
		redirectAtriAttributes.addFlashAttribute("building", building);
		return "redirect:/admin/room/add/" + building.getId();
	}
	
	@RequestMapping(value = { "/room/add/{id}" }, method = RequestMethod.GET)
	public String addNewRoom(Model model) {		
		return "building/add";
	}

	@RequestMapping(value = { "/room/add/{id}" }, method = RequestMethod.POST)
	public @ResponseBody Room ProcessNewRoom(@RequestBody Room room,
			@PathVariable("id") Integer id, Model model) {
		Building building = buildingService.getBuildingOne(id);
		building.getRooms().add(room);
		buildingService.addNewBuilding(building);
		room.setBuilding(building);
		roomService.addNewRoom(room);
		
		return room;
	}
}
