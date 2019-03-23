package com.hackcumple.eventsapp.repository;

import com.hackcumple.eventsapp.data.LostThing;
import com.hackcumple.eventsapp.data.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface LostRepository extends CrudRepository<LostThing, Long> {
}
