package com.cml.assignment.controller;

import com.cml.assignment.dto.BatchPayload;
import com.cml.assignment.model.Event;
import com.cml.assignment.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    // Assignment 01: Implementing CRUD operations for the Event Entity

    @GetMapping("/events")
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

    @PostMapping("/events")
    public Event saveEvent(@RequestBody Event event) {
        return eventService.saveEvent(event);
    }

    @PutMapping("/events")
    public Event updateEvent(@RequestBody Event event) {
        return eventService.updateEvent(event);
    }

    @DeleteMapping("/events/{id}")
    public void deleteEvent(@PathVariable String id) {
        eventService.deleteEvent(id);
    }

    // Assignment 02: Adding a new REST endpoint that accepts a json payload and extract the events to
    // save in the database
    @PostMapping("/events/batch")
    public List<Event> saveEvents(@RequestBody BatchPayload batchPayload) {
        System.out.println(batchPayload);
        return eventService.processAndSaveEvents(batchPayload);
    }
}
