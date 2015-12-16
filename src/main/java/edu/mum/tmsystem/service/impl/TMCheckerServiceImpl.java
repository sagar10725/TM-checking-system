package edu.mum.tmsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.tmsystem.domain.TMChecker;
import edu.mum.tmsystem.enums.StatusType;
import edu.mum.tmsystem.repository.ITMCheckerRepository;
import edu.mum.tmsystem.service.ITMCheckerService;

@Service
@Transactional
public class TMCheckerServiceImpl implements ITMCheckerService {

	@Autowired
	ITMCheckerRepository tmCheckerRepository;
	

	@Override
	public void addNewTmChecker(TMChecker tmchecker) {
		tmCheckerRepository.save(tmchecker);
		
	}

	@Override
	public List<TMChecker> getAllTmCheckers() {
		return (List<TMChecker>) tmCheckerRepository.findAll();
	}

	@Override
	public void disableTmCheckerById(Integer id) {
		TMChecker tmChecker = tmCheckerRepository.findOne(id);
		tmChecker.getUser().setStatus(StatusType.DISABLED);
		tmCheckerRepository.save(tmChecker);
		
	}

}
