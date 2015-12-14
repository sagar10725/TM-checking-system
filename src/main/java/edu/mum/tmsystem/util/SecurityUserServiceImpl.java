package edu.mum.tmsystem.util;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import edu.mum.tmsystem.domain.Role;
import edu.mum.tmsystem.domain.User;
import edu.mum.tmsystem.enums.StatusType;
import edu.mum.tmsystem.service.IUserService;

/**
 * Custom Spring Authentication and Authorization Class
 */
public class SecurityUserServiceImpl implements UserDetailsService {
	private static final Logger log = Logger.getLogger(SecurityUserServiceImpl.class);

	@Autowired
	IUserService userService;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		User user = null;
		try {
			user = userService.getUserByUsername(username);
		} catch (Exception e) {
			Utility.logError(log, e.getMessage(), e);
		}
		if (user == null) {
			throw new UsernameNotFoundException("Username doesn't exists");
		}
		List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());
		return buildUserForAuthentication(user, authorities);

	}

	private AuthenticatedUser buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
		Boolean enabled = false;
		if (user.getStatus().equals(StatusType.ACTIVE))
			enabled = true;

		AuthenticatedUser authenticatedUser = new AuthenticatedUser(user.getUsername(), user.getPassword(), enabled,
				true, true, true, authorities);

		authenticatedUser.setUserId(user.getId());
		authenticatedUser.setName(user.getName());
		authenticatedUser.setEmailAddress(user.getEmail());
		return authenticatedUser;

	}

	private List<GrantedAuthority> buildUserAuthority(List<Role> roles) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		// Build user's authorities
		try {
			for(Role role: roles){
				setAuths.add(new SimpleGrantedAuthority(role.getRoleType().toString()));
			}
			return new ArrayList<GrantedAuthority>(setAuths);
		} catch (Exception e) {
			throw e;
		}

	}

}
