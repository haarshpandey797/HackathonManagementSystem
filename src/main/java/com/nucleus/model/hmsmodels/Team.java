package com.nucleus.model.hmsmodels;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "EVENT_TEAM_HMS")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "team_id")
    private Long teamId;

    @Column(name = "team_name", nullable = false, unique = true)
    private String teamName;

    @Column(name = "team_size")
    private Integer teamSize;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    @ToString.Exclude
    private Event event;

    @ManyToOne
    @JoinColumn(name = "problem_statement_id")
    private ProblemStatement problemStatement;

    @Column(name = "status")
    private String status;

    @Column(name = "code_repository_link")
    private String codeRepositoryLink;

    @OneToMany(mappedBy = "team")
    @ToString.Exclude
    private List<Participant> participants;

    @OneToOne
    @JoinColumn(name = "team_result_id")
    private TeamResult teamResult;
}

