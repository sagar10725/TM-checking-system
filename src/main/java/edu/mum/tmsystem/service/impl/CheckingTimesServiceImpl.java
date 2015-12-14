package edu.mum.tmsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.tmsystem.domain.CheckingTimes;
import edu.mum.tmsystem.repository.ICheckingTimesRepository;
import edu.mum.tmsystem.service.ICheckingTimesService;

@Service
@Transactional
public class CheckingTimesServiceImpl implements ICheckingTimesService{
	
	@Autowired
	ICheckingTimesRepository checkingTimesRepository;

	@Override
	public void addCheckingTimes(CheckingTimes checkingTimes) {
		checkingTimesRepository.save(checkingTimes);		
	}

	@Override
	public List<CheckingTimes> getAllCheckingTimes() {
		return (List<CheckingTimes>) checkingTimesRepository.findAll();
	}

	@Override
	public void deleteCheckingTimes(Integer id) {
		checkingTimesRepository.delete(id);
	}
	
}
