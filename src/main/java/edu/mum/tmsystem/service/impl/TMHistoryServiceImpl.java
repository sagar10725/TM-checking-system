package edu.mum.tmsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.tmsystem.domain.TMHistory;
import edu.mum.tmsystem.repository.ITMHistoryRepository;
import edu.mum.tmsystem.service.ITMHistoryService;

@Service
@Transactional
public class TMHistoryServiceImpl implements ITMHistoryService{

	@Autowired
	ITMHistoryRepository tmHistoryRepository;
	
	@Override
	public List<TMHistory> getAllHistory() {
		// TODO Auto-generated method stub
		return (List<TMHistory>) tmHistoryRepository.findAll() ;
	}

	@Override
	public void deleteHistoryById(Long id) {
		// TODO Auto-generated method stub
		tmHistoryRepository.delete(id);
	}

	@Override
	public void saveHistory(TMHistory tmHistory) {
		tmHistoryRepository.save(tmHistory);
	}

}
