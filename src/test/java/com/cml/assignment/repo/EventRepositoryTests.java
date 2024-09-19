package com.cml.assignment.repo;

import com.cml.assignment.model.Event;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EventRepositoryTests {
    @Autowired
    private EventRepo eventRepo;

    @Test
    public void EventRepo_save_returnSavedEvent() {
        // arrange
        Event event = Event.builder()
                .eventId("29838882-4417-4da5-9359-e2797c7f8dcb")
                .transId("0000abf8-d1f5-4536-8fb0-36fe934b1f28")
                .transTms("20151022102011927EDT")
                .rcNum("10002")
                .clientId("RPS-00001")
                .eventCnt(1)
                .locationCd("DESTINATION")
                .locationId1("T8C")
                .locationId2("1J7")
                .addrNbr("0000000001").build();

        // act
        Event savedEvent = eventRepo.save(event);

        // assert
        Assertions.assertThat(savedEvent).isNotNull();
        Assertions.assertThat(savedEvent.getEventId()).isEqualTo(event.getEventId());
    }

    @Test
    public void EventRepo_saveAll_returnsSavedEvents() {
        // arrange
        Event event1 = Event.builder()
                .eventId("29838882-4417-4da5-9359-e2797c7f8dcb")
                .transId("0000abf8-d1f5-4536-8fb0-36fe934b1f28")
                .transTms("20151022102011927EDT")
                .rcNum("10002")
                .clientId("RPS-00001")
                .eventCnt(1)
                .locationCd("DESTINATION")
                .locationId1("T8C")
                .locationId2("1J7")
                .addrNbr("0000000001").build();
        Event event2 = Event.builder()
                .eventId("29345c82-4417-4da5-9359-e2797c7f8dcb")
                .transId("0000abf8-d1f5-4536-8fb0-36fe934b1f28")
                .transTms("20151022102011927EDT")
                .rcNum("10002")
                .clientId("RPS-00002")
                .eventCnt(1)
                .locationCd("TEST")
                .locationId1("T7C")
                .locationId2("1H7")
                .addrNbr("0000000435").build();
        List<Event> events = List.of(event1, event2);

        // act
        Iterable<Event> savedEvents = eventRepo.saveAll(events);

        // assert
        Assertions.assertThat(savedEvents).isNotNull();
        Assertions.assertThat(savedEvents).hasSize(2);
    }

    @Test
    public void EventRepo_findAll_returnsAllEvents() {
        // arrange
        Event event1 = Event.builder()
                .eventId("29838882-4417-4da5-5674-e2123df8dcb")
                .transId("0000abf8-d1f5-4536-8fb0-36fe934b1f28")
                .transTms("20151022102011927EDT")
                .rcNum("10006")
                .clientId("RPS-00001")
                .eventCnt(1)
                .locationCd("DESTINATION")
                .locationId1("T8C")
                .locationId2("1J7")
                .addrNbr("0000000001").build();
        Event event2 = Event.builder()
                .eventId("2234582-4417-4da5-9359-e2797c7f8dcb")
                .transId("0000abf8-d1f5-4536-8fb0-36fe934b1f28")
                .transTms("20151022102011927EDT")
                .rcNum("10002")
                .clientId("RPS-00002")
                .eventCnt(1)
                .locationCd("TEST")
                .locationId1("T7C")
                .locationId2("1H7")
                .addrNbr("0000000435").build();
        eventRepo.save(event1);
        eventRepo.save(event2);

        // act
        Iterable<Event> events = eventRepo.findAll();

        // assert
        Assertions.assertThat(events).isNotNull();
        Assertions.assertThat(events).hasSize(2);
    }

    @Test
    public void EventRepo_updateEvent_returnUpdatedEvent() {
        // arrange
        Event event = Event.builder()
                .eventId("29838882-4417-4da5-9359-e2797c7f8dcb")
                .transId("0000abf8-d1f5-4536-8fb0-36fe934b1f28")
                .transTms("20151022102011927EDT")
                .rcNum("10002")
                .clientId("RPS-00001")
                .eventCnt(1)
                .locationCd("DESTINATION")
                .locationId1("T8C")
                .locationId2("1J7")
                .addrNbr("0000000001").build();
        eventRepo.save(event);
        event.setClientId("RPS-00002");

        // act
        Event updatedEvent = eventRepo.save(event);

        // assert
        Assertions.assertThat(updatedEvent).isNotNull();
        Assertions.assertThat(updatedEvent.getClientId()).isEqualTo("RPS-00002");
    }

    @Test
    public void EventRepo_deleteEvent_returnNull() {
        // arrange
        Event event = Event.builder()
                .eventId("29838882-4417-4da5-9359-e2797c7f8dcb")
                .transId("0000abf8-d1f5-4536-8fb0-36fe934b1f28")
                .transTms("20151022102011927EDT")
                .rcNum("10002")
                .clientId("RPS-00001")
                .eventCnt(1)
                .locationCd("DESTINATION")
                .locationId1("T8C")
                .locationId2("1J7")
                .addrNbr("0000000001").build();
        eventRepo.save(event);

        // act
        eventRepo.deleteById("29838882-4417-4da5-9359-e2797c7f8dcb");

        // assert
        Assertions.assertThat(eventRepo.findById("29838882-4417-4da5-9359-e2797c7f8dcb")).isEmpty();
    }
}
