package com.vitthal.flightreservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vitthal.flightreservation.entities.User;
import com.vitthal.flightreservation.repos.UserRepository;
import com.vitthal.flightreservation.service.SecurityService;

@Controller
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private SecurityService securityService;

	@RequestMapping(value = "/showReg")
	public String userRegister() {
		LOGGER.info("inside userRegister(");
		return "login/registerUser";
	}

	@RequestMapping(value = "/showLogin")
	public String showLogin() {
		LOGGER.info("inside showLogin(");
		return "login/login";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		LOGGER.info("inside register()" + user);
		user.setPassword(encoder.encode(user.getPassword()));// encoded password here
		userRepository.save(user);
		return "login/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap) {
		LOGGER.info("inside login() and the Email is :" + email);
		//User user = userRepository.findByEmail(email);
		
		boolean loginResponse = securityService.login(email, password);
		if (loginResponse) {
			return "findFlights";
		} else {
			modelMap.addAttribute("msg", "Invalid Username Or Password , pls try again");
		}
		return "login/login";
	}
}
