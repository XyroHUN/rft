package com.rft.horariumapp.horariumapp.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rft.horariumapp.horariumapp.model.Task;
import com.rft.horariumapp.horariumapp.model.User;
import com.rft.horariumapp.horariumapp.service.UserService;


@RestController
public class LoginController {
	
	@Autowired
	private UserService userService;

	private final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public void regUser(@RequestBody @Valid User user) {
		User userExists = userService.findUserByEmail(user.getEmail());
		if(userExists != null) {	
			logger.info("email already in use");
		} else {
			userService.saveUser(user);
			logger.info("user saved");
		}
	}
	
	@RequestMapping(value = "/user/task", method = RequestMethod.POST)
	public void savetask(@RequestBody Task task) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		if(user.getTasks() == null) {
			ArrayList<Task> tasks = new ArrayList<>();
			tasks.add(task);
			user.setTasks(tasks);
		}else {
			user.getTasks().add(task);
		}
		userService.saveUser(user);
	}
	
	@RequestMapping(value="/user/home", method = RequestMethod.GET)
	public User home(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		return user;
	}
	
	
}
