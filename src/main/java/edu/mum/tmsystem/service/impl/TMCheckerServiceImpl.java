package edu.mum.tmsystem.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.tmsystem.domain.TMChecker;
import edu.mum.tmsystem.domain.User;
import edu.mum.tmsystem.domain.UserRole;
import edu.mum.tmsystem.enums.RoleType;
import edu.mum.tmsystem.enums.StatusType;
import edu.mum.tmsystem.repository.IRoleRepository;
import edu.mum.tmsystem.repository.ITMCheckerRepository;
import edu.mum.tmsystem.service.ITMCheckerService;
import edu.mum.tmsystem.util.Utility;

@Service
@Transactional
public class TMCheckerServiceImpl implements ITMCheckerService {

	@Autowired
	ITMCheckerRepository tmCheckerRepository;
	@Autowired
	IRoleRepository roleRepository;
	

	@Override
	public void addNewTmChecker(TMChecker tmchecker) {
		User user = tmchecker.getUser();
		user.setPassword(Utility.encryptPassword(user.getPassword()));
		user.setStatus(StatusType.ACTIVE);
		UserRole userRole = new UserRole();
		userRole.setRole(roleRepository.getRoleFromRoleName(RoleType.ROLE_TMCHECKER));
		userRole.setUser(user);
		user.setUserRoles(Arrays.asList(userRole));
		tmchecker.setUser(user);
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

	@Override
	public TMChecker getTMCheckerFromUserID(Long userId) {
		return tmCheckerRepository.findTMCheckerByUserId(userId);
	}

	@Override
	public void enableTmCheckerById(Integer id) {
		TMChecker tmChecker = tmCheckerRepository.findOne(id);
		tmChecker.getUser().setStatus(StatusType.ACTIVE);
		tmCheckerRepository.save(tmChecker);
		
	}
	
	

}
