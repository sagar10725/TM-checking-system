package edu.mum.tmsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.tmsystem.domain.CheckingHours;
import edu.mum.tmsystem.domain.Student;
import edu.mum.tmsystem.service.IAvailableEntryService;
import edu.mum.tmsystem.service.ICheckingHoursService;
import edu.mum.tmsystem.service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	IStudentService studentService;
	
	@Autowired
	IAvailableEntryService availableEntryService;
	
	@Autowired
	ICheckingHoursService checkingHoursService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getStrudent(Model model) {
		List<Student> studentList = studentService.getAllStudent();
		model.addAttribute("studentList", studentList);
		return "student/studentDetails";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String deleteStudent(@PathVariable("id") Long id, @ModelAttribute("studentList") Student student) {
		studentService.deleteStudentById(id);
		return "student/studentDetails";
	}
	
	@RequestMapping(value = "/available_dates", method = RequestMethod.GET)
	public String getListOfAvailableDates(Model model) {
		model.addAttribute("availableEntries", availableEntryService.getAllAvailableEntriesWithAvailableSeats());
		return "student/signupfortm";
	}
	
	@RequestMapping(value = "/signupfortm/{checkingHourId}", method = RequestMethod.POST)
	public @ResponseBody Boolean signUpForTM(@PathVariable("checkingHourId") Integer checkingHourId) {
		checkingHoursService.signUpForGivenCheckingHour(checkingHourId);
		return true;
	}
	

}
