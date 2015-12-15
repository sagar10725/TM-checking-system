package edu.mum.tmsystem.service;

import edu.mum.tmsystem.domain.User;

public interface IUserService {
	
	public void saveStudent(User user);
	
	public User getUserByUsername(String username);

	public User getUserById(Long id);

	public void updateStudent(User user);

}
