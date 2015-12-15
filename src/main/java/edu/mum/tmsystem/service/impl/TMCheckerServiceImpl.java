package edu.mum.tmsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.tmsystem.domain.TMHistory;
import edu.mum.tmsystem.repository.ITMCheckerRepository;
import edu.mum.tmsystem.service.ITMCheckerService;

@Service
@Transactional
public class TMCheckerServiceImpl implements ITMCheckerService {

	@Autowired
	ITMCheckerRepository tmCheckerRepository;
	
	@Override
	public void save(TMHistory studentData) {
		tmCheckerRepository.save(studentData);
		
	}

	@Override
	public List<TMHistory> getDetails() {
		return (List<TMHistory>) tmCheckerRepository.findAll();
	}

}
