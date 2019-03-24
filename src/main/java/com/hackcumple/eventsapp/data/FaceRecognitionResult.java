package com.hackcumple.eventsapp.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class FaceRecognitionResult {
    private int numberOfPeople;
    private String image;
}
