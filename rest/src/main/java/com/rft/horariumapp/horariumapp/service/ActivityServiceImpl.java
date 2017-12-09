package com.rft.horariumapp.horariumapp.service;

import com.rft.horariumapp.horariumapp.model.Activity;
import com.rft.horariumapp.horariumapp.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public List<Activity> listActivities() {
        return activityRepository.findAll();
    }

    @Override
    public void removeActivityById(String id) {
        activityRepository.delete(id);
    }

    @Override
    public void addActivity(Activity activity) {
        activityRepository.insert(activity);
    }
}
