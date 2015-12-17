package edu.mum.tmsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.tmsystem.domain.CheckingHours;
import edu.mum.tmsystem.domain.Student;
import edu.mum.tmsystem.domain.TMHistory;
import edu.mum.tmsystem.enums.TMStatusType;
import edu.mum.tmsystem.exception.BusinessException;
import edu.mum.tmsystem.repository.ICheckingHoursRepository;
import edu.mum.tmsystem.service.IAvailableEntryService;
import edu.mum.tmsystem.service.ICheckingHoursService;
import edu.mum.tmsystem.service.IStudentService;
import edu.mum.tmsystem.service.ITMHistoryService;
import edu.mum.tmsystem.util.DateUtil;
import edu.mum.tmsystem.util.SessionManager;

@Service
@Transactional
public class CheckingHoursServiceImpl implements ICheckingHoursService{
	
	@Autowired
	ICheckingHoursRepository checkingHoursRepository;
	
	@Autowired
	IStudentService studentService;
	
	@Autowired
	ITMHistoryService tmHistoryService;
	
	@Autowired
	IAvailableEntryService availableEntryService;

	@Override
	@PreAuthorize(value = "hasRole('ROLE_STUDENT')")
	public CheckingHours signUpForGivenCheckingHour(Integer checkingHourId) throws BusinessException {
		CheckingHours checkingHours = checkingHoursRepository.findOne(checkingHourId);
		if(checkingHours.getSignUpBy() != null){
			throw new BusinessException("Already signup by others");
		}
		Student student = studentService.getStudentByUserId(SessionManager.getUserID());
		checkingHours.setSignUpBy(student);
		
		TMHistory tmHistory = new TMHistory();
		tmHistory.setCheckingHours(checkingHours);
		tmHistory.setCheckingType(checkingHours.getAvailableEntry().getCheckingType());
		tmHistory.setSignUpDate(DateUtil.getCurrentDate());
		tmHistory.setRoom(checkingHours.getAvailableEntry().getRoom());
		tmHistory.setStatus(TMStatusType.PENDING);
		tmHistory.setStudent(student);
		
		tmHistoryService.saveHistory(tmHistory);	
		
		availableEntryService.updateNumberOfSeats(checkingHours.getAvailableEntry().getId());
		
		return checkingHoursRepository.save(checkingHours);
	}

}
