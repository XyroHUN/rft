package com.rft.horariumapp.horariumapp.service;

import com.rft.horariumapp.horariumapp.model.Activity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActivityService {
    List<Activity> listActivities();
    void addActivity(Activity activity);
    void removeActivityById(String id);
}
