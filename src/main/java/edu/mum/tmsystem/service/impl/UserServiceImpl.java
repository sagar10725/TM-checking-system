package edu.mum.tmsystem.service.impl;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;

import edu.mum.tmsystem.domain.User;
import edu.mum.tmsystem.domain.UserRole;
import edu.mum.tmsystem.enums.RoleType;
import edu.mum.tmsystem.enums.StatusType;
import edu.mum.tmsystem.repository.IRoleRepository;
import edu.mum.tmsystem.repository.IUserRepository;
import edu.mum.tmsystem.service.IUserService;
import edu.mum.tmsystem.util.Utility;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository userRepository;

	@Autowired
	IRoleRepository roleRepository;

	@Override
	public void saveStudent(User user) {
		user.setPassword(Utility.encryptPassword(user.getPassword()));
		user.setStatus(StatusType.INACTIVE);
		UserRole userRole = new UserRole();
		userRole.setRole(roleRepository.getRoleFromRoleName(RoleType.ROLE_STUDENT));
		userRole.setUser(user);
		user.setUserRoles(Arrays.asList(userRole));
		userRepository.save(user);
	}

	@Override
	public User getUserByUsername(String username) {
		return userRepository.getUserFromUsername(username);
	}

	@Override
	public boolean changePassword(String oldpassword, String newpassword, String confirmpassword) {
		if(!newpassword.equals(confirmpassword)){
			return false;
		}
		
		String username = Utility.getLoggedInUserName();
		User user = userRepository.getUserFromUsername(username);
		String password = user.getPassword();
		if(!Utility.matchPassword(oldpassword, password)){
			return false;
		}
		String changedpassword = newpassword;
		user.setPassword(Utility.encryptPassword(changedpassword));
		userRepository.save(user);
		return true;
	}
	
	@Override
	public User getUserProfileById(Long id) {
		User user = userRepository.findOne(id);
		if(user.getImagePath() != null)
			user.setImageFile(Base64Utils.encodeToString(Utility.getImageFromPath(Utility.IMAGE_UPLOAD_PATH + user.getImagePath())));
		return user;
	}

	@Override
	public void updateUser(User user) {
		User dbUser = userRepository.findOne(user.getId());
		dbUser.setEmail(user.getEmail());
		dbUser.setName(user.getName());
		dbUser.setImagePath(user.getImagePath());
		dbUser.getStudent().setStudentId(user.getStudent().getStudentId());
		dbUser.getStudent().setEntryYear(user.getStudent().getEntryYear());
		dbUser.getStudent().setEntryMonth(user.getStudent().getEntryMonth());
		userRepository.save(dbUser);
	}
	
	public User getUserById(Long id) {
		return (User) userRepository.findOne(id);
	}

	@Override
	public void updateStudent(User user) {
		userRepository.save(user);
		
	}

	@Override
	public void addNewTmChecker(User user) {
		user.setPassword(Utility.encryptPassword(user.getPassword()));
		user.setStatus(StatusType.ACTIVE);
		UserRole userRole = new UserRole();
		userRole.setRole(roleRepository.getRoleFromRoleName(RoleType.ROLE_TMCHECKER));
		userRole.setUser(user);
		user.setUserRoles(Arrays.asList(userRole));
		userRepository.save(user);
		
	}

	@Override
	public List<User> getAllUser() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public void changeStatus(Long id, StatusType status) {
		User user = userRepository.findOne(id);
		user.setStatus(status);
		userRepository.save(user);
	}

	

}
