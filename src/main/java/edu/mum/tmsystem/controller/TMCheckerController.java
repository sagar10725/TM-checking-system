package edu.mum.tmsystem.controller;

import java.text.ParseException;
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

import edu.mum.tmsystem.domain.AvailableEntry;
import edu.mum.tmsystem.domain.Building;
import edu.mum.tmsystem.domain.Room;
import edu.mum.tmsystem.domain.Student;
import edu.mum.tmsystem.domain.TMHistory;
import edu.mum.tmsystem.enums.CheckingType;
import edu.mum.tmsystem.enums.TMStatusType;
import edu.mum.tmsystem.exception.BusinessException;
import edu.mum.tmsystem.service.IAvailableEntryService;
import edu.mum.tmsystem.service.IBuildingService;
import edu.mum.tmsystem.service.IStudentService;
import edu.mum.tmsystem.service.ITMHistoryService;

@Controller
@RequestMapping("/tmchecker")
public class TMCheckerController {

	@Autowired
	IBuildingService buildingService;

	@Autowired
	IAvailableEntryService availableEntryService;

	@Autowired
	ITMHistoryService tmHistoryService;
	
	@Autowired
	IStudentService studentService;

//	@ModelAttribute("checkingtype")
//	private CheckingType[] checkingtype() {
//		return CheckingType.values();
//	}

	@RequestMapping(value = {"","/","/home"}, method = RequestMethod.GET)
	public String loadLandingPage(Model model) {
		return "tmchecker/home";
	}

	@RequestMapping(value = "/get_rooms/{buildingId}", method = RequestMethod.GET)
	public @ResponseBody List<Room> loadRooms(
			@PathVariable("buildingId") Integer buildingId) {
		List<Room> rooms = buildingService.getAllRoomByBuildingId(buildingId);
		return rooms;
	}

	@RequestMapping(value = "/available_dates/add", method = RequestMethod.GET)
	public String addAvailableDateForm(
			@ModelAttribute("availableEntry") AvailableEntry availableEntry,
			Model model) {
		List<Building> buildings = buildingService.getAllBuildings();
		model.addAttribute("buildings", buildings);
		model.addAttribute("checkingtype", CheckingType.values());
		return "tmchecker/available_checking";
	}

	@RequestMapping(value = "/available_dates/add", method = RequestMethod.POST)
	public String addAvailableDates(
			@Valid @ModelAttribute("availableEntry") AvailableEntry availableEntry,
			BindingResult result, Model model,
			RedirectAttributes redirectAttributes) throws ParseException,
			BusinessException {
		if (availableEntry.getRoom() == null
				|| availableEntry.getRoom().getId() == null) {
			ObjectError objectError = new ObjectError("room",
					"Room must be chosen");
			result.addError(objectError);
		}
		if (result.hasErrors()) {
			List<Building> buildings = buildingService.getAllBuildings();
			model.addAttribute("buildings", buildings);
			model.addAttribute("checkingtype", CheckingType.values());
			return "tmchecker/available_checking";
		}
		List<Building> buildings = buildingService.getAllBuildings();
		model.addAttribute("buildings", buildings);

		availableEntryService.saveAvailableEntry(availableEntry);
		redirectAttributes.addFlashAttribute("saveMessage",
				"Entry has been saved successfully");
		return "redirect:add";
	}

	@RequestMapping(value = "/viewsignups", method = RequestMethod.GET)
	public String getAllSignUps(Model model) {
		model.addAttribute("tmHistories", tmHistoryService.getAllHistory());
		return "tmchecker/allsignups";
	}

	@RequestMapping(value = "/addnewcheckingentry", method = RequestMethod.GET)
	public String showNewCheckingEntryForm(
			@Valid @ModelAttribute("tmhistory") TMHistory tmHistory, Model model) {
		model.addAttribute("checkingType", CheckingType.values());
		List<Student> students = studentService.getAllStudent();
		model.addAttribute("students", students);
		List<Building> buildings = buildingService.getAllBuildings();
		model.addAttribute("buildings", buildings);
		return "tmchecker/addNewCheckingEntry";
	}

	@RequestMapping(value = "/addnewcheckingentry", method = RequestMethod.POST)
	public String processNewCheckingEntryForm(
			@Valid @ModelAttribute("tmhistory") TMHistory tmHistory,
			BindingResult bindingResult, Model model) {
		if (tmHistory.getRoom().getId() == null) {
			ObjectError objectError = new ObjectError("room",
					"Room must be chosen");
			bindingResult.addError(objectError);
		}
		if (tmHistory.getStudent().getId() == null) {
			ObjectError objectError = new ObjectError("studentID",
					"Student ID must be chosen");
			bindingResult.addError(objectError);
		}
		if (bindingResult.hasErrors()) {
			model.addAttribute("checkingType", CheckingType.values());
			List<Student> students = studentService.getAllStudent();
			model.addAttribute("students", students);
			List<Building> buildings = buildingService.getAllBuildings();
			model.addAttribute("buildings", buildings);
			return "tmchecker/addNewCheckingEntry";
		}
		tmHistoryService.addNewChecking(tmHistory);
		return "redirect:/tmchecker/viewsignups";
	}
	
	@RequestMapping(value = "/changetmstatus", method = RequestMethod.GET)
	public String getSignUpsStatus(Model model) {
		model.addAttribute("tmHistories", tmHistoryService.getAllHistory());
		return "tmchecker/changeTmStatus";
	}
	

	@RequestMapping(value = "/changetmstatus/{id}", method = RequestMethod.GET)
	public String processSignUpsStatus(@PathVariable("id") Integer id, @RequestParam("status") TMStatusType status, Model model) {
		tmHistoryService.changeStatus(id, status);
		return "redirect:/tmchecker/changetmstatus";
	}

}
