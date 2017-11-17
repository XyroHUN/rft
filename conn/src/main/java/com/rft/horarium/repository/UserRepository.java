package com.rft.horarium.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rft.horarium.model.User;

public interface UserRepository extends CrudRepository<User,Long> {
	List<User> findByEmail(String email);
}
