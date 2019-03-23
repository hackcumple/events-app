package com.hackcumple.eventsapp.repository;

import com.hackcumple.eventsapp.data.Question;
import com.hackcumple.eventsapp.data.Rate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
public interface QuestionRepository extends CrudRepository<Question, Long> {

    Optional<Question> findByPresentationId(Long presentationId);
}
