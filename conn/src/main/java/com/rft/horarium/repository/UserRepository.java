package com.rft.horarium.repository;
import org.springframework.data.repository.CrudRepository;

import com.rft.horarium.model.User;

public interface UserRepository extends CrudRepository<User,Long> {

}
