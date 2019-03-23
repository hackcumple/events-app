package com.hackcumple.eventsapp.resources;

import com.hackcumple.eventsapp.services.FaceRecognitionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/face-recognition")
public class FaceRecognitionResource {

    private final FaceRecognitionService faceRecognitionService;

    @GetMapping
    public ResponseEntity getFacesAmount() {
        try {
            return ResponseEntity.ok(this.faceRecognitionService.getFacesAmount());
        } catch (IOException e) {
            return ResponseEntity.noContent().build();
        }
    }
}
