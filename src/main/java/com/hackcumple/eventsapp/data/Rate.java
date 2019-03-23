package com.hackcumple.eventsapp.data;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Builder
@AllArgsConstructor
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "SPEAKERNAME")
    String speakerName;
    @Column(name = "PRESENTATIONID")
    Long presentationId;
    Instant date;
    Double rate;
}
