package edu.mum.tmsystem.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.ValidationUtils;

import edu.mum.tmsystem.domain.Role;
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
		// TODO Auto-generated method stub
		
		System.out.println("Oldpassword Password*********** :-"+ oldpassword );
		if(!newpassword.equals(confirmpassword)){
			//System.out.println("NewPassword Password*********** :-"+ newpassword  + "  " + confirmpassword );
			return false;
		}
		
		String username = Utility.getLoggedInUserName();
		User user = userRepository.getUserFromUsername(username);
		String password = user.getPassword();
		try {
			if(!Utility.matchPassword(oldpassword, password)){
				
				System.out.println("Inside Password*********** :-"+ newpassword  + "  " + confirmpassword );
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String changedpassword = newpassword;
		System.out.println("changed Password*********** :-"+ changedpassword);
		user.setPassword(Utility.encryptPassword(changedpassword));
		userRepository.save(user);
		
		return true;
	}

	

}
