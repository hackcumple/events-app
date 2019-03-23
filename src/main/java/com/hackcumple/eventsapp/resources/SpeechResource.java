package com.hackcumple.eventsapp.resources;

import com.hackcumple.eventsapp.services.SpeechService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/speech")
@RequiredArgsConstructor
public class SpeechResource {

    private final SpeechService speechService;

    @GetMapping(path = "uploadAudio/{fileName}")
    public ResponseEntity uploadAudio(@PathVariable("fileName")String fileName) {
        return ResponseEntity.ok().body(speechService.uploadAudio(fileName));
    }

    @GetMapping(path = "getTranscriptionDetails/{orderId}")
    public ResponseEntity getTranscriptionDetails(@PathVariable("orderId")String orderId) {
        speechService.GetTranscriptionDetails(orderId);
        return ResponseEntity.ok().build();
    }
}
