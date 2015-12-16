package edu.mum.tmsystem.service;

import java.text.ParseException;
import java.util.List;

import edu.mum.tmsystem.domain.AvailableEntry;
import edu.mum.tmsystem.enums.CheckingType;

public interface IAvailableEntryService {
	
	public List<AvailableEntry> getAllAvailableEntries();

	public void deleteAvailableEntryById(Long id);

	public List<AvailableEntry> getAvailableEntriesByCheckingType(CheckingType checkingType);

	public AvailableEntry getAvailableEntry(Long id);

	public void saveAvailableEntry(AvailableEntry availableEntry) throws ParseException;
	
	public List<AvailableEntry> getAllAvailableEntriesWithAvailableSeats();
}
