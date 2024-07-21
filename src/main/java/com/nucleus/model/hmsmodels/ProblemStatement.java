package com.nucleus.model.hmsmodels;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "PROBLEM_STATEMENT_HMS")
public class ProblemStatement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "problem_statement_id")
    private Long problemStatementId;

    @Column(name = "problem_name", nullable = false)
    private String problemName;

    @Column(name = "problem_description")
    private String problemDescription;

    @Column(name = "problem_link",unique = true)
    private String problemLink;

    @Column(name = "status")
    private String status;

    @Column(name = "adoption_status")
    private String adoptionStatus;

    @ManyToMany(mappedBy = "problemStatements")
    @ToString.Exclude
    private List<Event> events = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "judge_id", nullable = false)
    @ToString.Exclude
    private Judge owner;

    @OneToMany(mappedBy = "problemStatement")
    @ToString.Exclude
    private List<Team> workingTeams = new ArrayList<>();

}
