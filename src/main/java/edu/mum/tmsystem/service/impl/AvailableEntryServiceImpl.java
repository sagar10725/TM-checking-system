package edu.mum.tmsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.tmsystem.domain.AvailableEntry;
import edu.mum.tmsystem.domain.User;
import edu.mum.tmsystem.enums.CheckingType;
import edu.mum.tmsystem.repository.IAvailableEntryRepository;
import edu.mum.tmsystem.repository.IUserRepository;
import edu.mum.tmsystem.service.IAvailableEntryService;
import edu.mum.tmsystem.util.SessionManager;

@Service
@Transactional
public class AvailableEntryServiceImpl implements IAvailableEntryService{
	
	@Autowired
	IAvailableEntryRepository availableEntryRepository;
	
	@Autowired
	//IUserService userService; /* ASK PROFESSOR WHICH IS GOOD AND WHY */
	IUserRepository userRepository;

	@Override
	public List<AvailableEntry> getAllAvailableEntries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAvailableEntryById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AvailableEntry> getAvailableEntriesByCheckingType(CheckingType checkingType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AvailableEntry getAvailableEntry(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAvailableEntry(AvailableEntry availableEntry) {
		User user = userRepository.findOne(SessionManager.getUserID());
		//availableEntry.getAddedBy()
		availableEntryRepository.save(availableEntry);
		
	}

}
