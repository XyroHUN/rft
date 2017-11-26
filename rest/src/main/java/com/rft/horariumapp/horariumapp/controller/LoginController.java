package com.rft.horariumapp.horariumapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.rft.horariumapp.horariumapp.model.User;
import com.rft.horariumapp.horariumapp.service.UserService;


@RestController
public class LoginController {
	
	@Autowired
	private UserService userService;

	private final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String login(){
		//ModelAndView modelAndView = new ModelAndView();
		//modelAndView.setViewName("login");
		return "hello";
	}
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public List<User> getAll(){
		List<User> userExists = userService.findAll();
		return userExists;
	}
	
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public void createNewUser(@Valid User user, BindingResult bindingResult) {
		User userExists = userService.findUserByEmail(user.getEmail());
		if(userExists != null) {	
			logger.info("email already in use");
		} else {
			userService.saveUser(user);
			logger.info("user saved");
		}
	}
	
}
