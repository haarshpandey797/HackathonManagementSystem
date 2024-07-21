package com.nucleus.model.hmsmodels;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="EVALUATION_ENTRY_HMS")
public class EvaluationEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="evaluation_entry_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="judge_id")
    private Judge judge;

    @ManyToOne
    @JoinColumn(name="criteria_id")
    private Criteria criteria;

    @Column(name="evaluation_date")
    private LocalDate evaluationDate;

    @Column(name="remark")
    private String remark;

    @Column(name="score", columnDefinition = "NUMBER(10, 2)")
    private Double score;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

}
