package edu.mum.tmsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.tmsystem.domain.Room;
import edu.mum.tmsystem.domain.Student;
import edu.mum.tmsystem.domain.TMChecker;
import edu.mum.tmsystem.domain.TMHistory;
import edu.mum.tmsystem.domain.User;
import edu.mum.tmsystem.enums.TMStatusType;
import edu.mum.tmsystem.repository.ITMHistoryRepository;
import edu.mum.tmsystem.service.IRoomService;
import edu.mum.tmsystem.service.IStudentService;
import edu.mum.tmsystem.service.ITMCheckerService;
import edu.mum.tmsystem.service.ITMHistoryService;
import edu.mum.tmsystem.service.IUserService;
import edu.mum.tmsystem.util.Utility;

@Service
@Transactional
public class TMHistoryServiceImpl implements ITMHistoryService{

	@Autowired
	ITMHistoryRepository tmHistoryRepository;
	
	@Autowired
	IStudentService studentService;
	
	@Autowired
	IRoomService roomService;
	
	@Autowired
	ITMCheckerService tmCheckerService;
	
	@Autowired
	IUserService userService;
	
	@Override
	public List<TMHistory> getAllHistory() {
		// TODO Auto-generated method stub
		return (List<TMHistory>) tmHistoryRepository.findAll() ;
	}

	@Override
	public void deleteHistoryById(Integer id) {
		// TODO Auto-generated method stub
		tmHistoryRepository.delete(id);
	}

	@Override
	public void saveHistory(TMHistory tmHistory) {
		tmHistoryRepository.save(tmHistory);
	}

	@Override
	public List<TMHistory> getAllHistoryByStudentID(Long studentId) {
		return tmHistoryRepository.getTMHistoriesByStudentID(studentId);
	}

	@Override
	public void addNewChecking(TMHistory tmHistory) {
		
		Student student = studentService.getStudentById(tmHistory.getStudent().getId());
		tmHistory.setStudent(student);
		Room room = roomService.getRoomById(tmHistory.getRoom().getId());
		tmHistory.setRoom(room);
		tmHistory.setStatus(TMStatusType.CHECKED);
		tmHistoryRepository.save(tmHistory);
		User loggedUser = userService.getUserByUsername(Utility.getLoggedInUserName());
		TMChecker tmchecker = tmCheckerService.getTMCheckerFromUserID(loggedUser.getId());
		tmHistory.setCheckedBy(tmchecker);
		tmHistoryRepository.save(tmHistory);
		
	}

	@Override
	public void changeStatus(Integer id, TMStatusType status) {
		TMHistory tmHistory = tmHistoryRepository.findOne(id);
		tmHistory.setStatus(status);
		tmHistoryRepository.save(tmHistory);
		
	}

}
