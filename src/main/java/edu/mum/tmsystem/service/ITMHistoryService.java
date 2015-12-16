package edu.mum.tmsystem.service;

import java.util.List;

import edu.mum.tmsystem.domain.TMHistory;

public interface ITMHistoryService {

	public List<TMHistory> getAllHistory();
	
	public void deleteHistoryById(Long id);
	
	public void saveHistory(TMHistory tmHistory);
	
}
