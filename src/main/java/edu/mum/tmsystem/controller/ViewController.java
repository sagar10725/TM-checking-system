package edu.mum.tmsystem.controller;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.tmsystem.enums.RoleType;
import edu.mum.tmsystem.util.SessionManager;
import edu.mum.tmsystem.util.Utility;

@Controller
public class ViewController {

	private static Logger logger = Logger.getLogger(ViewController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loadFirstPage() {
		if (Utility.getLoggedInUserName() != null) {
			logger.info("User already logged in:" + Utility.getLoggedInUserName());
			return "redirect:/home";
		}
		logger.info("Retriving login page");
		return "redirect:/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginSignUpPage() {
		if (Utility.getLoggedInUserName() != null) {
			logger.info("User already logged in:" + Utility.getLoggedInUserName());
			return "redirect:/home";
		}
		logger.info("Retriving login page");
		return "login";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String welcomePage() {
		if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null
				&& !SessionManager.isAnonymousUser()) {
			if (SessionManager.getRole().equals(RoleType.ROLE_ADMIN)) {
				return "redirect:/admin";
			} else if (SessionManager.getRole().equals(RoleType.ROLE_STUDENT)) {
				return "home";
			}
		}
		return "redirect:/login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "redirect:/";
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String accessdeniedPage() {
		return "accessdenied";
	}

}
