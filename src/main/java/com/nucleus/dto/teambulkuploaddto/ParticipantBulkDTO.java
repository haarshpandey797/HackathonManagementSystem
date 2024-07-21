package com.nucleus.dto.teambulkuploaddto;

import lombok.Data;

@Data
public class ParticipantBulkDTO {
    private Long participantId;
    private String participantName;
    private String participantRole;
    private String participantEmail;
    private String participantPhone;
    private String participantEmployeeId;
    private String participantBU;
    private String designation;
    private TeamBulkDTO teamID;
}
