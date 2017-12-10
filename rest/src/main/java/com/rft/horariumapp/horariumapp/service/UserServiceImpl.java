package com.rft.horariumapp.horariumapp.service;

import com.rft.horariumapp.horariumapp.exceptions.UserAlreadyExistsException;
import com.rft.horariumapp.horariumapp.model.User;
import com.rft.horariumapp.horariumapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.security.Principal;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void register(@Valid User user) {
        if (!userRepository.existsUserByEmail(user.getEmail())) {
            userRepository.save(user);
        } else {
            throw new UserAlreadyExistsException("User already exists.");
        }
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public String getCurrentUserEmail() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
