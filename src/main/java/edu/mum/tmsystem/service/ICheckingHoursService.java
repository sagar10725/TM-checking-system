package edu.mum.tmsystem.service;

import edu.mum.tmsystem.domain.CheckingHours;
import edu.mum.tmsystem.exception.BusinessException;

public interface ICheckingHoursService {
	public CheckingHours signUpForGivenCheckingHour(Integer checkingHourId) throws BusinessException;
}
