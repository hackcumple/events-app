package com.hackcumple.eventsapp.data.transcriptionDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Sentence {
    public String sentence;
    public String confidence;
    public Double startTime;
    public Double endTime;
}
