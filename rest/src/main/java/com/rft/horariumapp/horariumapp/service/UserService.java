package com.rft.horariumapp.horariumapp.service;

import com.rft.horariumapp.horariumapp.model.User;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public interface UserService {
    void register(User user);
    User getUserByEmail(String email);
    String getCurrentUserEmail();
}
