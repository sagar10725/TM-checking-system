package edu.mum.tmsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.tmsystem.domain.DefaultCheckingSeats;
import edu.mum.tmsystem.enums.CheckingType;
import edu.mum.tmsystem.repository.IDefaultCheckingSeatsRepository;
import edu.mum.tmsystem.service.IDefaultCheckingSeatsService;

@Service
@Transactional
public class DefaultCheckingSeatsServiceImpl implements IDefaultCheckingSeatsService{
	
	@Autowired
	IDefaultCheckingSeatsRepository checkingSeatsRepository;

	@Override
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	public void saveCheckingSeats(DefaultCheckingSeats checkingSeats) {
		// TODO Auto-generated method stub
		checkingSeatsRepository.save(checkingSeats);
	}

	@Override
	public DefaultCheckingSeats getDefaultCheckingSeatsByCheckingType(
			CheckingType checkingType) {
		return (DefaultCheckingSeats) checkingSeatsRepository.findDefaultCheckingSeatsByCheckingType(checkingType);
	}

}
