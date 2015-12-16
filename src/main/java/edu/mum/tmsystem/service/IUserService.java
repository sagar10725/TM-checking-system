package edu.mum.tmsystem.service;

import java.util.List;

import edu.mum.tmsystem.domain.User;
import edu.mum.tmsystem.enums.StatusType;

public interface IUserService {

	public void saveStudent(User user);

	public User getUserByUsername(String username);

	public User getUserProfileById(Long id);

	public void updateUser(User user);

	public User getUserById(Long id);

	public void updateStudent(User user);

	public void addNewTmChecker(User user);

	public List<User> getAllUser();

	public void changeStatus(Long id, StatusType status);
	
}
