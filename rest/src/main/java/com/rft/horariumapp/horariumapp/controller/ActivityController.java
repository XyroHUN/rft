package com.rft.horariumapp.horariumapp.controller;

import com.rft.horariumapp.horariumapp.model.Activity;
import com.rft.horariumapp.horariumapp.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Activity>> listActivities() {
        return new ResponseEntity<>(activityService.listActivities(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addActivity(@RequestBody Activity activity) {
        activityService.addActivity(activity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.DELETE)
    public  ResponseEntity<Void> removeActivity(@PathVariable String id) {
        activityService.removeActivityById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
