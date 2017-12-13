package com.rft.horariumapp.horariumapp.controller;

import com.rft.horariumapp.horariumapp.model.Event;
import com.rft.horariumapp.horariumapp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Event>> listEvents() {
        return new ResponseEntity<>(eventService.listEvents(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> generateEvents() {
        eventService.generateEvents();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
