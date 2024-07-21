package com.nucleus.dto.teambulkuploaddto;

import com.nucleus.dto.EventDTO;
import lombok.Data;

@Data
public class TeamBulkDTO {
    private String teamName;
    private Integer teamSize;
    private Long eventID;
    private String status;
    private String codeRepositoryLink;
}
