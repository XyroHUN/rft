package com.rft.horariumapp.horariumapp.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rft.horariumapp.horariumapp.model.Task;
import com.rft.horariumapp.horariumapp.model.Time;
import com.rft.horariumapp.horariumapp.model.User;
import com.rft.horariumapp.horariumapp.repository.UserRepository;


@Service("userService")
public class UserServiceImp implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	@Override
	public void saveTask(User user, Task task, Time time) {
		List<Task> tasks = new ArrayList<>();
		List<Time> times = new ArrayList<>();
		
		if(user.getTasks() != null) {
			times.add(new Time(time.getDay(),time.getHours()));
			task.setTime(times);
			user.getTasks().add(task);
		}else {
			tasks.add(task);
			user.setTasks(tasks);
		}
		userRepository.save(user);
	}

}
