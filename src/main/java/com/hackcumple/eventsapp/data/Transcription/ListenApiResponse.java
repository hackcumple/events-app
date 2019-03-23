package com.hackcumple.eventsapp.data.Transcription;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ListenApiResponse {
    public int code;
    public String msg;
    public String status;
    public TranscriptionResult result;
}
