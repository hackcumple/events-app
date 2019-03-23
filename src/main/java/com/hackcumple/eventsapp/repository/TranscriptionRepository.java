package com.hackcumple.eventsapp.repository;

import com.hackcumple.eventsapp.data.Transcription;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TranscriptionRepository extends CrudRepository<Transcription, Long> {

    Optional<Transcription> findByPresentationId(Long presentationId);

}
