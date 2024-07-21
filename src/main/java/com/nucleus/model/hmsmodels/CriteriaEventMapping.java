package com.nucleus.model.hmsmodels;


import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "CRITERIA_EVENT_MAPPING_HMS")
@Data
public class CriteriaEventMapping {

    @Id
    @Column(name = "criteria_event_mapping_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "criteria_id")
    private Criteria criteria;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(name = "max_score")
    private int maxScore;

    @Column(name = "weightage")
    private int weightage;

}
