package com.hackcumple.eventsapp.resources;

import com.hackcumple.eventsapp.services.SpeechService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/speech")
@RequiredArgsConstructor
public class SpeechResource {

    private final SpeechService speechService;

    @GetMapping(path = "getTranscriptionDetails/{orderId}")
    public ResponseEntity getTranscriptionDetails(@PathVariable("orderId")String orderId) {
        return new ResponseEntity<>(speechService.GetTranscriptionDetails(orderId), HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity uploadAudio(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(this.speechService.uploadAudio(file));
    }
}
