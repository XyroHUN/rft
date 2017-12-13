package com.rft.horariumapp.horariumapp.businessLogic;

import com.rft.horariumapp.horariumapp.model.Activity;
import com.rft.horariumapp.horariumapp.model.Event;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

public class ActivityListToEventListConverter implements Converter<List<Activity>, List<Event>> {

    @Override
    public List<Event> convert(List<Activity> activities) {
        return activities.stream()
                .map(
                        activity -> Event.builder()
                            .id(activity.getId())
                            .name(activity.getName())
                            .ownerEmail(activity.getOwnerEmail())
                            .times(activity.getTimes())
                            .build()
                ).collect(Collectors.toList());
    }
}
