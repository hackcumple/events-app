package com.hackcumple.eventsapp.data;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class SpeakerRate {
    String speaker;
    List<Double> rates;
    Long amountRates;

    public SpeakerRate(String speaker, Double rate) {
        this.speaker = speaker;
        this.rates = Collections.singletonList(rate);
        this.amountRates = 1L;
    }

    public void incrementAmountRates(){
        this.amountRates++;
    }

    public boolean equals(String speaker) {
        return this.speaker.equals(speaker);
    }
}
