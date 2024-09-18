package com.cml.assignment.controller;

import com.cml.assignment.model.Event;
import com.cml.assignment.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/")
    public String greet() {
        return eventService.greet();
    }

    @GetMapping("/events")
    public List<Event> getEvents() {
        return eventService.getEvents();
    }
}
