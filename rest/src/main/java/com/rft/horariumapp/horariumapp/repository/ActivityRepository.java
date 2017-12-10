package com.rft.horariumapp.horariumapp.repository;

import com.rft.horariumapp.horariumapp.model.Activity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends MongoRepository<Activity, String> {
    List<Activity> findActivitiesByOwnerEmail(String ownerEmail);
}
