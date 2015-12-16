package edu.mum.tmsystem.service;

import java.util.List;

import edu.mum.tmsystem.domain.TMChecker;

public interface ITMCheckerService {

	public void addNewTmChecker(TMChecker tmchecker);

	public List<TMChecker> getAllTmCheckers();

	public void disableTmCheckerById(Integer id);
	
	public TMChecker getTMCheckerFromUserID(Long userId);
}
