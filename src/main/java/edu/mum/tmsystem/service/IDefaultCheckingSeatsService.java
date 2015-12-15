package edu.mum.tmsystem.service;

import edu.mum.tmsystem.domain.DefaultCheckingSeats;
import edu.mum.tmsystem.enums.CheckingType;

public interface IDefaultCheckingSeatsService {

	public void saveCheckingSeats(DefaultCheckingSeats checkingSeats);
	
	public DefaultCheckingSeats getDefaultCheckingSeatsByCheckingType(CheckingType checkingType);

}
