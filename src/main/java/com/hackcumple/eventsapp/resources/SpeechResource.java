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

    @GetMapping(path = "getTranscriptionDetails/{presentationId}")
    public ResponseEntity getTranscriptionDetails(@PathVariable("presentationId")Long presentationId) {
        return new ResponseEntity<>(speechService.GetTranscriptionDetails(presentationId), HttpStatus.OK);
    }

    @PostMapping("/upload/{presentationId}")
    public ResponseEntity uploadAudio(@RequestParam("file") MultipartFile file,@PathVariable Long presentationId) {
        return ResponseEntity.ok(this.speechService.uploadAudio(file,presentationId));
    }
}
