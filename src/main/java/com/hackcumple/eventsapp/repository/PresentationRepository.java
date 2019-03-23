package com.hackcumple.eventsapp.repository;

import com.hackcumple.eventsapp.data.Presentation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PresentationRepository extends CrudRepository<Presentation, Long> {

        List<Presentation> findPresentationsByEventIdAndStartHour(Long eventId, Long startHour);
}
