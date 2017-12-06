package com.rft.horariumapp.horariumapp.service;

import java.util.List;

import com.rft.horariumapp.horariumapp.model.Task;
import com.rft.horariumapp.horariumapp.model.Time;
import com.rft.horariumapp.horariumapp.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
	public List<User> findAll();
}
