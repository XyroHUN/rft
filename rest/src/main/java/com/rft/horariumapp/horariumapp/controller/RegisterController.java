package com.rft.horariumapp.horariumapp.controller;

import com.rft.horariumapp.horariumapp.model.User;
import com.rft.horariumapp.horariumapp.service.UserService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/register")
@Slf4j
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> register(@RequestBody User user) {
        userService.register(user);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
