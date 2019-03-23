package com.hackcumple.eventsapp.resources;

import com.hackcumple.eventsapp.data.Event;
import com.hackcumple.eventsapp.data.Ticket;
import com.hackcumple.eventsapp.repository.EventRepository;
import com.hackcumple.eventsapp.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/login")
@RequiredArgsConstructor
public class TicketResource {
    private final TicketRepository ticketRepository;
    private final EventRepository eventRepository;

    @GetMapping(path = "{ticketId}")
    public ResponseEntity getEventForTicket(@PathVariable("ticketId")Long ticketId) {
        Optional<Ticket> ticket = ticketRepository.findById(ticketId);
        Long eventId = ticket.get().getEventId();
        Optional<Event> event = eventRepository.findById(eventId);
        return ResponseEntity.ok().body(event.get());
    }
}
