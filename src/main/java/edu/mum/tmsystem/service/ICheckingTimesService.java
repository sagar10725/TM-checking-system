package edu.mum.tmsystem.service;

import java.util.List;

import edu.mum.tmsystem.domain.CheckingTimes;

public interface ICheckingTimesService {
	public void addCheckingTimes(CheckingTimes checkingTimes);
	
	public List<CheckingTimes> getAllCheckingTimes();
	
	public void deleteCheckingTimes(Integer id);
}
