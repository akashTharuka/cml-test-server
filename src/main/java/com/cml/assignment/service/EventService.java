package com.cml.assignment.service;

import com.cml.assignment.dto.BatchPayload;
import com.cml.assignment.dto.EventDTO;
import com.cml.assignment.dto.RecordDTO;
import com.cml.assignment.model.Event;
import com.cml.assignment.repo.EventRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    public Event saveEvent(Event event) {
        event.setEventId(UUID.randomUUID().toString());
        return eventRepo.save(event);
    }

    public Event updateEvent(Event event) {
        return eventRepo.save(event);
    }

    public void deleteEvent(String id) {
        eventRepo.deleteById(id);
    }

    public List<Event> processAndSaveEvents(BatchPayload batchPayload) {
        List<Event> events = new ArrayList<>();
        for (RecordDTO recordDTO: batchPayload.getRecords()) {
            for (EventDTO eventDTO: recordDTO.getEvent()) {
                Event event = new Event();
                event.setEventId(UUID.randomUUID().toString());
                event.setTransId((recordDTO.getTransId()));
                event.setTransTms(recordDTO.getTransTms());
                event.setRcNum(recordDTO.getRcNum());
                event.setClientId(recordDTO.getClientId());
                event.setEventCnt(eventDTO.getEventCnt());
                event.setLocationCd(eventDTO.getLocationCd());
                event.setLocationId1(eventDTO.getLocationId1());
                event.setLocationId2(eventDTO.getLocationId2());
                event.setAddrNbr(eventDTO.getAddrNbr());
                System.out.println(event);
                events.add(event);
            }
        }
        return eventRepo.saveAll(events);
    }
}
