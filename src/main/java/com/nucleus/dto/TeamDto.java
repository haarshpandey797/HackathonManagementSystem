package com.nucleus.dto;

import com.nucleus.model.hmsmodels.Event;
import com.nucleus.model.hmsmodels.Participant;
import com.nucleus.model.hmsmodels.ProblemStatement;
import com.nucleus.model.hmsmodels.TeamResult;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class TeamDto {
    private Long teamId;
    private String teamName;
    private Integer teamSize;
    private Event event;
    private ProblemStatement problemStatement;
    private String status;
    private String codeRepositoryLink;
    private List<ParticipantDTO> participants;
    private TeamResult teamResult;
}