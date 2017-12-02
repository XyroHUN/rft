package com.rft.horariumapp.horariumapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rft.horariumapp.horariumapp.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	public User findByEmail(String email);
}
