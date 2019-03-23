package com.hackcumple.eventsapp.resources;

import com.hackcumple.eventsapp.data.Event;
import com.hackcumple.eventsapp.data.Ticket;
import com.hackcumple.eventsapp.repository.EventRepository;
import com.hackcumple.eventsapp.repository.LostRepository;
import com.hackcumple.eventsapp.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/lost")
@RequiredArgsConstructor
public class LostThingsResource {
    private final LostRepository lostRepository;

    @GetMapping()
    public ResponseEntity getLostThings() {
        return new ResponseEntity<>(lostRepository.findAll(), HttpStatus.OK);

    }
}
