package com.hackcumple.eventsapp.data.Transcription;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class TranscriptionResult {
    public List<Sentence> sentence;
    public String text;
    public List<Word> word;
}
