package com.rft.horariumapp.horariumapp.service;

import com.rft.horariumapp.horariumapp.model.Event;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EventService {
    void generateEvents();
    List<Event> listEvents();

}
