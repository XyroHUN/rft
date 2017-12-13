package com.rft.horariumapp.horariumapp.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Builder
public class Event {

    @Id
    private String id;

    private String name;
    private String ownerEmail;
    private List<Time> times;
}
