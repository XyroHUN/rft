package com.rft.horariumapp.horariumapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {
	
	@RequestMapping(value="/registration",method = RequestMethod.GET)
    public String regpage(){
        return "registration";
    }
	
	@RequestMapping(value="/",method = RequestMethod.GET)
    public String homepage(){
        return "login";
    }

	@RequestMapping(value="/login",method = RequestMethod.GET)
    public String loginpage(){
        return "login";
    }
	
}
