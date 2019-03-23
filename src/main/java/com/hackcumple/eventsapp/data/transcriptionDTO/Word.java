package com.hackcumple.eventsapp.data.transcriptionDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Word {
    public Double startTime;
    public Double endTime;
    public String word;
}
