package com.hackcumple.eventsapp.data;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Builder
@AllArgsConstructor
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

    public Presentation cloneToFavoriteTrack() {
        return Presentation.builder()
                .name(this.name)
                .startHour(this.startHour)
                .speaker(this.speaker)
                .tag("FAVORITE")
                .build();

    }
}
