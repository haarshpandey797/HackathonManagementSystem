package com.nucleus.model.hmsmodels;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PARTICIPANT_HMS")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "participant_id")
    private Long participantId;

    @Column(name = "participant_name", nullable = false)
    private String participantName;

    @Column(name = "participant_role")
    private String participantRole;

    @Column(name = "participant_email")
    private String participantEmail;

    @Column(name = "participant_phone")
    private String participantPhone;

    @Column(name = "participant_employee_id")
    private String participantEmployeeId;

    @Column(name = "participant_bu")
    private  String participantBU;

    @Column(name = "designation")
    private String designation;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;
}

