package com.rft.horarium.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rft.horarium.model.User;
import com.rft.horarium.repository.UserRepository;

@RestController
public class RestWebController {
	
	@Autowired
	UserRepository repository;
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public void registerUser(@RequestBody User user){
		repository.save(new User(user.getEmail(), user.getPassword()));
	}
	
}