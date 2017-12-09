package com.rft.horariumapp.horariumapp.repository;

import com.rft.horariumapp.horariumapp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
    Boolean existsUserByEmail(String email);
    User findUserByEmail(String email);
}
