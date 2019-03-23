package com.hackcumple.eventsapp.repository;

import com.hackcumple.eventsapp.data.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
