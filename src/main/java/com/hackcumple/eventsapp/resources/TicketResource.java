package com.hackcumple.eventsapp.resources;

import com.hackcumple.eventsapp.data.Event;
import com.hackcumple.eventsapp.data.Ticket;
import com.hackcumple.eventsapp.repository.EventRepository;
import com.hackcumple.eventsapp.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/login")
@RequiredArgsConstructor
public class TicketResource {
    private final TicketRepository ticketRepository;
    private final EventRepository eventRepository;

    //@CrossOrigin(origins = "http://10.100.99.47:8080")
    @GetMapping(path = "{ticketId}")
    public ResponseEntity getEventForTicket(@PathVariable("ticketId")Long ticketId) {
        Optional<Ticket> ticket = ticketRepository.findById(ticketId);
        Long eventId = ticket.get().getEventId();
        Optional<Event> event = eventRepository.findById(eventId);
        return ResponseEntity.ok().body(event.get());
    }
}
