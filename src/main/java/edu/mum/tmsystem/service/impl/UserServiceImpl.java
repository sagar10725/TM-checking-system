package edu.mum.tmsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.tmsystem.domain.User;
import edu.mum.tmsystem.repository.IUserRepository;
import edu.mum.tmsystem.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Autowired
	IUserRepository userRepository;

	@Override
	public void saveStudent(User user) {
		//System.out.println(user.toString());
		userRepository.save(user);
	}

	@Override
	public User getUserByUsername(String username) {
		return userRepository.getUserFromUsername(username);
	}

	

}
