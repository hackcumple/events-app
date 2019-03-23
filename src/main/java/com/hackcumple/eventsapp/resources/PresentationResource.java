package com.hackcumple.eventsapp.resources;

import com.hackcumple.eventsapp.services.PresentationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/presentation")
@RequiredArgsConstructor
public class PresentationResource {


    private final PresentationService presentationService;

    @GetMapping(path = "favouriteTrack/{eventId}/{tags}")
    public ResponseEntity getFavoriteTrack(@PathVariable("eventId")Long eventId,@PathVariable("tags")String tags) {
        return new ResponseEntity<>(presentationService.getFavoriteTrack(eventId,tags), HttpStatus.OK);
    }
}
