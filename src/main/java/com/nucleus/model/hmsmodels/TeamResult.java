package com.nucleus.model.hmsmodels;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="TEAM_RESULT_HMS")
public class TeamResult {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="team_result_id")
    private Long resultId;

    @Column(name="final_score", columnDefinition = "NUMBER(10, 2)")
    private Double finalScore;

    @Column(name="rank")
    private Integer rank;

}
