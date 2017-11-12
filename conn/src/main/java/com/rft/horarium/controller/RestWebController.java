package com.rft.horarium.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rft.horarium.model.User;

@RestController
public class RestWebController {
	
	List<User> usr = new ArrayList<User>();
	
	@RequestMapping(value="/postcustomer", method=RequestMethod.POST)
	public String postCustomer(User user){
		usr.add(user);
		
		return "Sucessful!";
	}
	
}