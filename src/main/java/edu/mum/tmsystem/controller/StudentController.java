package edu.mum.tmsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.tmsystem.domain.Student;
import edu.mum.tmsystem.exception.BusinessException;
import edu.mum.tmsystem.service.IAvailableEntryService;
import edu.mum.tmsystem.service.ICheckingHoursService;
import edu.mum.tmsystem.service.IStudentService;
import edu.mum.tmsystem.service.ITMHistoryService;
import edu.mum.tmsystem.util.SessionManager;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	IStudentService studentService;
	
	@Autowired
	IAvailableEntryService availableEntryService;
	
	@Autowired
	ICheckingHoursService checkingHoursService;
	
	@Autowired
	ITMHistoryService tmHistoryService;
	
	@RequestMapping(value = {"","/","/home"}, method = RequestMethod.GET)
	public String loadLandingPage(Model model) {
		return "student/home";
	}	
	
	@RequestMapping(value = "/available_dates", method = RequestMethod.GET)
	public String getListOfAvailableDates(Model model) {
		model.addAttribute("availableEntries", availableEntryService.getAllAvailableEntriesWithAvailableSeats());
		return "student/signupfortm";
	}
	
	@RequestMapping(value = "/signupfortm/{checkingHourId}", method = RequestMethod.POST)
	public @ResponseBody Boolean signUpForTM(@PathVariable("checkingHourId") Integer checkingHourId) throws BusinessException {
		checkingHoursService.signUpForGivenCheckingHour(checkingHourId);
		return true;
	}
	
	@RequestMapping(value = "/mysignups", method = RequestMethod.GET)
	public String getMySignUps(Model model) {
		Student student = studentService.getStudentByUserId(SessionManager.getUserID());
		model.addAttribute("tmHistories", tmHistoryService.getAllHistoryByStudentID(student.getId()));
		return "student/mysignups";
	}
	

}
