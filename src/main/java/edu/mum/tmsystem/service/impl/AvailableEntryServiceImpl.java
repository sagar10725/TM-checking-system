package edu.mum.tmsystem.service.impl;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.tmsystem.domain.AvailableEntry;
import edu.mum.tmsystem.domain.CheckingHours;
import edu.mum.tmsystem.domain.DefaultCheckingSeats;
import edu.mum.tmsystem.domain.TMChecker;
import edu.mum.tmsystem.enums.CheckingType;
import edu.mum.tmsystem.repository.IAvailableEntryRepository;
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
		availableEntry.setAvailableSeats(defaultCheckingSeats.getNumberOfSeats() * availableEntry.getCheckingTimes().length);
		Set<CheckingHours> checkingHoursSets = new HashSet<CheckingHours>();
		for(String checkingTime : availableEntry.getCheckingTimes()){
			if(availableEntry.getCheckingType().equals(CheckingType.GROUP)){
				for(int i=0; i<defaultCheckingSeats.getNumberOfSeats(); i++){
					CheckingHours checkingHours = new CheckingHours();
					checkingHours.setAvailableEntry(availableEntry);
					checkingHours.setCheckingDate(DateUtil.getCombinedDateTime(availableEntry.getCheckingDate(), checkingTime));
					checkingHoursSets.add(checkingHours);
				}
			}else{
				CheckingHours checkingHours = new CheckingHours();
				checkingHours.setAvailableEntry(availableEntry);
				checkingHours.setCheckingDate(DateUtil.getCombinedDateTime(availableEntry.getCheckingDate(), checkingTime));
				checkingHoursSets.add(checkingHours);
			}
		}
		availableEntry.setCheckingHours(checkingHoursSets);
		availableEntryRepository.save(availableEntry);
		
	}
	
	@Override
	public List<AvailableEntry> getAllAvailableEntriesWithAvailableSeats(){
		return availableEntryRepository.getAllAvailableEntriesWithAvailableSeats();
	}

	@Override
	public AvailableEntry update(AvailableEntry availableEntry) {
		return availableEntryRepository.save(availableEntry);
	}

	@Override
	public void updateNumberOfSeats(Long availableEntryId) {
		AvailableEntry availableEntry = availableEntryRepository.findOne(availableEntryId);
		availableEntry.setAvailableSeats(availableEntry.getAvailableSeats() -1);
		availableEntryRepository.save(availableEntry);
	}
	

}
