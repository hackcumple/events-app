package com.hackcumple.eventsapp.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String description;
    Instant date;
    String city;
    @Column(name = "STREETNAME")
    String streetName;
    @Column(name = "STREETNUMBER")
    String streetNumber;
}
