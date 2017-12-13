package com.rft.horariumapp.horariumapp.service;

import com.rft.horariumapp.horariumapp.businessLogic.Horarium;
import com.rft.horariumapp.horariumapp.model.Event;
import com.rft.horariumapp.horariumapp.model.Time;
import com.rft.horariumapp.horariumapp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Component
public class EventServiceImpl implements EventService {

    @Autowired
    UserService userService;

    @Autowired
    ActivityService activityService;

    @Autowired
    EventRepository eventRepository;

    @Override
    public void generateEvents() {

        String email = userService.getCurrentUserEmail();
        eventRepository.removeEventsByOwnerEmail(email);


        Horarium horarium = new Horarium();
        eventRepository.save(horarium.getResult(activityService.listActivities()));
        /*
        eventRepository.save(
            Arrays.asList(
                Event.builder().ownerEmail(email).times(
                        Collections.singletonList(Time.builder().day(0).hours(Arrays.asList(4, 5, 6, 7)).build())
                ).name("teszt1").build(),
                Event.builder().ownerEmail(email).times(
                        Collections.singletonList(Time.builder().day(1).hours(Arrays.asList(9,10,11,12,13)).build())
                ).name("teszt2").build(),
                Event.builder().ownerEmail(email).times(
                        Arrays.asList(
                                Time.builder().day(2).hours(Arrays.asList(21,22)).build(),
                                Time.builder().day(3).hours(Arrays.asList(20,21,22)).build()
                        )
                ).name("teszt3").build(),
                Event.builder().ownerEmail(email).times(
                        Arrays.asList(
                                Time.builder().day(5).hours(Arrays.asList(4,5,6,7)).build(),
                                Time.builder().day(6).hours(Arrays.asList(4,5,6,7)).build()
                        )
                ).name("teszt4").build()
            )
        );
        */
    }

    @Override
    public List<Event> listEvents() {
        return eventRepository.findAllByOwnerEmail(userService.getCurrentUserEmail());
    }
}
