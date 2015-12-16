package edu.mum.tmsystem.service;

import java.util.List;

import edu.mum.tmsystem.domain.TMChecker;
import edu.mum.tmsystem.domain.TMHistory;

public interface ITMCheckerService {

	public void addNewTmChecker(TMChecker tmchecker);

	public List<TMChecker> getAllTmCheckers();

	public void disableTmCheckerById(Integer id);
}
