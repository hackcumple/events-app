package com.hackcumple.eventsapp.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Presentation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;
    String description;
    Double rate;
    String tag;
    String speaker;
    @Column(name = "EVENTID")
    Long eventId;
    @Column(name = "STARTHOUR")
    Long startHour;
}
