package com.hackcumple.eventsapp.repository;

import com.hackcumple.eventsapp.data.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
