package edu.mum.tmsystem.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.tmsystem.domain.Building;
import edu.mum.tmsystem.domain.Room;
import edu.mum.tmsystem.domain.TMHistory;
import edu.mum.tmsystem.enums.CheckingType;
import edu.mum.tmsystem.enums.TMStatusType;
import edu.mum.tmsystem.service.IBuildingService;
import edu.mum.tmsystem.service.impl.BuildingServiceImpl;

@Controller
@RequestMapping("/tmcheck")
public class TMCheckerController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String loadLandingPage(Model model) {
		return "tmchecker/home";
	}
	/*
	 * @Autowired //ITMCheckerService tmCheckerService;
	 * 
	 * @RequestMapping(method = RequestMethod.GET) public String
	 * addNewTmCheckForm(@ModelAttribute("tmchecker") TMHistory tmchecker) {
	 * 
	 * // model.addAttribute("checkingtype", CheckingType.values()); return
	 * "tmchecker/checkstatus"; }
	 * 
	 * 
	 * 
	 * @ModelAttribute("status") public TMStatusType[] statustype() { return
	 * TMStatusType.values(); }
	 * 
	 * @RequestMapping(method = RequestMethod.POST) public String
	 * saveCheckForm(@ModelAttribute("tmchecker") TMHistory tmHistory) {
	 * System.out.println(tmHistory.toString());
	 * tmCheckerService.save(tmHistory); return "tmchecker/thankyoupage"; }
	 * 
	 * @RequestMapping(value="/historydetails", method=RequestMethod.GET) public
	 * String showHistoryDetails(@ModelAttribute("historydetails")TMHistory
	 * historyDetails, Model model){
	 * 
	 * 
	 * List<TMHistory> history = tmCheckerService.getDetails();
	 * model.addAttribute("history",history); return"tmchecker/checkdetails"; }
	 */

	@ModelAttribute("checkingtype")
	public CheckingType[] checkingtype() {
		return CheckingType.values();
	}

	@Autowired
	IBuildingService buildingService;

	@RequestMapping(value = "/checkingform", method = RequestMethod.GET)
	public String checkingForm(@ModelAttribute("tmhistory") TMHistory tmhistory, Model model) {
		List<Building> buildings = buildingService.getAllBuildings();
		System.out.println(buildings.size());
		model.addAttribute("buildings", buildings);
		// model.addAttribute("checkingtype",CheckingType.values());
		return "tmchecker/checkdetails";
	}

	@RequestMapping(value="/get_rooms/{buildingId}", method=RequestMethod.GET)
	public @ResponseBody List<Room> loadRooms(@PathVariable("buildingId") Integer buildingId){
		List<Room> rooms =  buildingService.getAllRoomByBuildingId(buildingId);
		return rooms;
	}
}

>>>>>>>.theirs
