package com.hackcumple.eventsapp.data.Transcription;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Word {
    public Double startTime;
    public Double endTime;
    public String word;
}
