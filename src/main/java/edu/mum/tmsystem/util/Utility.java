package edu.mum.tmsystem.util;

import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.mum.tmsystem.exception.BusinessException;

public class Utility {
	private static Logger logger = Logger.getLogger(Utility.class);

	public static void logError(Logger log, String message, Exception e) {
		if (e instanceof BusinessException)
			logger.info(e.getMessage());
		else
			logger.error(message, e);
	}

	public static String encryptPassword(String password) {
		if (password != null && !password.isEmpty()) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			return passwordEncoder.encode(password);
		}
		return null;
	}
	
	public static Boolean matchPassword(String rawPassword, String dbEncryptedPassword) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, dbEncryptedPassword);
    }

	public static String getRandomString(){
		return UUID.randomUUID().toString();
	}
	
	public static String getLoggedInUserName(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetails = (UserDetails) auth.getPrincipal();
			return userDetails.getUsername();
		}
		return null;
	}
	
	public static Date getCurrentDateTime(){
		return new Date();
	}

}
