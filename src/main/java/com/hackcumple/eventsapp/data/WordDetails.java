package com.hackcumple.eventsapp.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class WordDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String word;
    int count;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    Transcription transcription;

}
