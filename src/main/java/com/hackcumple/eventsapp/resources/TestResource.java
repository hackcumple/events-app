package com.hackcumple.eventsapp.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestResource {

    //@CrossOrigin(origins = "http://localhost:8081")
    @GetMapping
    public ResponseEntity testMethod() {
        return ResponseEntity.ok().body("Witaj Szynom");
    }
}
