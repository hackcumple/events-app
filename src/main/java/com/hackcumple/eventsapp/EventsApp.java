package com.hackcumple.eventsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class EventsApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(EventsApp.class, args);
    }

}
