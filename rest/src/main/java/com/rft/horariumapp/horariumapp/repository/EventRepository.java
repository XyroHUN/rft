package com.rft.horariumapp.horariumapp.repository;

import com.rft.horariumapp.horariumapp.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EventRepository extends MongoRepository<Event, String> {
    void removeEventsByOwnerEmail(String ownerEmail);
    List<Event> findAllByOwnerEmail(String ownerEmail);
}
