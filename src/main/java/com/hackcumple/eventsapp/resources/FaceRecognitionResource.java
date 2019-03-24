package com.hackcumple.eventsapp.resources;

import com.hackcumple.eventsapp.services.FaceRecognitionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/face-recognition")
public class FaceRecognitionResource {

    private final FaceRecognitionService faceRecognitionService;

    @PostMapping(value = "/image")
    public ResponseEntity getProcessedImg(@RequestParam("file") MultipartFile file) {
        try {
            return ResponseEntity.ok(this.faceRecognitionService.getFaceRecognitionImg(file.getBytes()));
        } catch (IOException e) {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping(value = "/amount")
    public ResponseEntity getFacesAmount(@RequestParam("file") MultipartFile file) {
        try {
            return ResponseEntity.ok(this.faceRecognitionService.getFacesAmount(file.getBytes()));
        } catch (IOException e) {
            return ResponseEntity.noContent().build();
        }
    }
}
