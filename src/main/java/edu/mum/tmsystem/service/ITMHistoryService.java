package edu.mum.tmsystem.service;

import java.util.List;

import edu.mum.tmsystem.domain.TMHistory;
import edu.mum.tmsystem.enums.TMStatusType;

public interface ITMHistoryService {

	public List<TMHistory> getAllHistory();
	
	public void deleteHistoryById(Integer id);
	
	public void saveHistory(TMHistory tmHistory);
	
	public List<TMHistory> getAllHistoryByStudentID(Long studentId);

	public void addNewChecking(TMHistory tmHistory);

	public void changeStatus(Integer id, TMStatusType status);
	
}
