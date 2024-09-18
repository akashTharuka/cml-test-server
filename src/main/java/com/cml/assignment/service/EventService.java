package com.cml.assignment.service;

import com.cml.assignment.model.Event;
import com.cml.assignment.repo.EventRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventService {

    private final EventRepo eventRepo;

    public String greet() {
        return "Hello World";
    }


    public List<Event> getEvents() {
        return eventRepo.findAll();
    }
}
