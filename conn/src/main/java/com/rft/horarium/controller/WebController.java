package com.rft.horarium.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

	@RequestMapping("/")
    public String homepage(){
        return "index";
    }
	
	@RequestMapping("/register")
    public String registerpage(){
        return "register";
    }

}