package com.hackcumple.eventsapp.data;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class RateDTO {
    Double rate;
    Instant date;
}
