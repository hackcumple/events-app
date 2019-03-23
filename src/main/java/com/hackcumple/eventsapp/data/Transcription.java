package com.hackcumple.eventsapp.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Transcription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "PRESENTATIONID")
    Long presentationId;

    @Column(name = "SPEAKERNAME")
    String speakerName;

    @Column(name = "ORDERID")
    String orderId;

    String text;

    @Column(name = "WORDDETAILS")
    @OneToMany(mappedBy = "transcription", cascade = CascadeType.ALL)
    List<WordDetails> wordDetails;

}