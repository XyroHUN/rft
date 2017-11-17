package com.rft.horarium.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rft.horarium.message.Response;
import com.rft.horarium.model.User;
import com.rft.horarium.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository repository;
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public void registerUser(@RequestBody User user){
		repository.save(new User(user.getEmail(), user.getPassword()));
	}
	
	@RequestMapping("/login")
	public Response findByEmail(@RequestParam("email") String email, @RequestParam("password") String password) {
		
		User user = repository.findByEmail(email);
		try {
			if(user.getPassword().equals(password)) {
				return new Response("Done", user);
			}else {
				return new Response("Fail", user);
			}
		}catch(Exception e) {
			return new Response("Not Found","Not Found");
		}
				
		
	}
	
}