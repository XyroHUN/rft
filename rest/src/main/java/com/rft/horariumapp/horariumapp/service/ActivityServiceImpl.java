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

    @Autowired
    private UserService userService;

    @Override
    public List<Activity> listActivities() {
        return activityRepository.findActivitiesByOwnerEmail(userService.getCurrentUserEmail());
    }

    @Override
    public void removeActivityById(String id) {
        activityRepository.delete(id);
    }

    @Override
    public void addActivity(Activity activity) {
        activity.setOwnerEmail(userService.getCurrentUserEmail());
        activityRepository.insert(activity);
    }
}
