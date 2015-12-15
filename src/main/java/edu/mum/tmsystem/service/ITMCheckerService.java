package edu.mum.tmsystem.service;

import java.util.List;

import edu.mum.tmsystem.domain.TMChecker;
import edu.mum.tmsystem.domain.TMHistory;

public interface ITMCheckerService {

	public void save(TMHistory studentData);

	public List<TMHistory> getDetails();
	
	public TMChecker getTMCheckerFromUserID(Long userId);
}
