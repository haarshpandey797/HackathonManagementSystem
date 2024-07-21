package com.nucleus.model.hmsmodels;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "EVENT_ORGANISER_MAPPING_HMS")
public class EventOrganiserMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "event_organiser_mapping_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "organiser_id")
    private Organiser organiser;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "responsibility")
    private String responsibility;

}
