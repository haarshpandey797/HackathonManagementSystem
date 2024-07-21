package com.nucleus.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ParticipantDTO {
    private Long participantId;
    private String participantName;
    private String participantRole;
    private String participantEmail;
    private String participantPhone;
    private String participantEmployeeId;
    private String participantBU;
    private String designation;
    private TeamDto team;
}