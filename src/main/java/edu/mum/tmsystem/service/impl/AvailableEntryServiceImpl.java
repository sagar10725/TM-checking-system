package edu.mum.tmsystem.service.impl;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.tmsystem.domain.AvailableEntry;
import edu.mum.tmsystem.domain.CheckingHours;
import edu.mum.tmsystem.domain.DefaultCheckingSeats;
import edu.mum.tmsystem.domain.TMChecker;
import edu.mum.tmsystem.domain.User;
import edu.mum.tmsystem.enums.CheckingType;
import edu.mum.tmsystem.repository.IAvailableEntryRepository;
import edu.mum.tmsystem.repository.IUserRepository;
import edu.mum.tmsystem.service.IAvailableEntryService;
import edu.mum.tmsystem.service.IDefaultCheckingSeatsService;
import edu.mum.tmsystem.service.ITMCheckerService;
import edu.mum.tmsystem.util.DateUtil;
import edu.mum.tmsystem.util.SessionManager;

@Service
@Transactional
public class AvailableEntryServiceImpl implements IAvailableEntryService{
	
	@Autowired
	IAvailableEntryRepository availableEntryRepository;
	
	@Autowired
	ITMCheckerService tmCheckerService;
	
	@Autowired
	IDefaultCheckingSeatsService defaultCheckingSeatsService;

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
	public void saveAvailableEntry(AvailableEntry availableEntry) throws ParseException {
		TMChecker tmChecker = tmCheckerService.getTMCheckerFromUserID(SessionManager.getUserID());
		availableEntry.setAddedBy(tmChecker);
		DefaultCheckingSeats defaultCheckingSeats = defaultCheckingSeatsService.getDefaultCheckingSeatsByCheckingType(availableEntry.getCheckingType());
		availableEntry.setAvailableSeats(defaultCheckingSeats.getNumberOfSeats());
		Set<CheckingHours> checkingHoursSets = new HashSet<CheckingHours>();
		for(String checkingTime : availableEntry.getCheckingTimes()){
			CheckingHours checkingHours = new CheckingHours();
			checkingHours.setAvailableEntry(availableEntry);
			checkingHours.setCheckingDate(DateUtil.getCombinedDateTime(availableEntry.getCheckingDate(), checkingTime));
			checkingHoursSets.add(checkingHours);
		}
		availableEntry.setCheckingHours(checkingHoursSets);
		availableEntryRepository.save(availableEntry);
		
	}

}
