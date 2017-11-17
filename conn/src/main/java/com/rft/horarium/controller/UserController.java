package com.rft.horarium.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rft.horarium.model.User;
import com.rft.horarium.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository repository;
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public void registerUser(@RequestBody @Valid User user){
		User userexists = repository.findByEmail(user.getEmail());
		if(userexists != null) {
			System.out.println("already registered");
		}else {
			repository.save(new User(user.getEmail(), user.getPassword()));
		}
	}
	
	@RequestMapping("/login")
	public String findByEmail(@RequestParam("email") String email, @RequestParam("password") String password) {
		
		User user = repository.findByEmail(email);
		try {
			if(user.getPassword().equals(password)) {
				return "activities";
			}else {
				return "";
			}
		}catch(Exception e) {
			return "error";
		}
	}
	
}