package edu.mum.tmsystem.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.tmsystem.domain.AvailableEntry;
import edu.mum.tmsystem.domain.Building;
import edu.mum.tmsystem.domain.Room;
import edu.mum.tmsystem.enums.CheckingType;
import edu.mum.tmsystem.service.IAvailableEntryService;
import edu.mum.tmsystem.service.IBuildingService;

@Controller
@RequestMapping("/tmchecker")
public class TMCheckerController {

	@Autowired
	IBuildingService buildingService;

	@Autowired
	IAvailableEntryService availableEntryService;

	@ModelAttribute("checkingtype")
	private CheckingType[] checkingtype() {
		return CheckingType.values();
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String loadLandingPage(Model model) {
		return "tmchecker/home";
	}

	@RequestMapping(value = "/get_rooms/{buildingId}", method = RequestMethod.GET)
	public @ResponseBody List<Room> loadRooms(@PathVariable("buildingId") Integer buildingId) {
		List<Room> rooms = buildingService.getAllRoomByBuildingId(buildingId);
		return rooms;
	}

	@RequestMapping(value = "/available_dates/add", method = RequestMethod.GET)
	public String addAvailableDateForm(@ModelAttribute("availableEntry") AvailableEntry availableEntry, Model model) {
		List<Building> buildings = buildingService.getAllBuildings();
		model.addAttribute("buildings", buildings);
		return "tmchecker/available_checking";
	}

	@RequestMapping(value = "/available_dates/add", method = RequestMethod.POST)
	public String addAvailableDates(@ModelAttribute("availableEntry") AvailableEntry availableEntry, Model model)
			throws ParseException {
		List<Building> buildings = buildingService.getAllBuildings();
		model.addAttribute("buildings", buildings);

		availableEntryService.saveAvailableEntry(availableEntry);
		System.out.println(availableEntry.toString());
		return "tmchecker/available_checking";
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

}
