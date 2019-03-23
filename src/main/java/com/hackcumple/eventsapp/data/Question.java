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
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String speaker;
    @Column(name = "PRESENTATIONID")
    Long presentationId;
    String question;
    Long rating;

    public void incrementRating(){
        this.rating++;
    }
}
