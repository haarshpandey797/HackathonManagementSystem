package com.nucleus.dto;

import com.nucleus.model.hmsmodels.Event;
import com.nucleus.model.hmsmodels.Team;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class ProblemStatementMasterDto {
    private Long problemStatementId;

    private String problemName;

    private String problemDescription;

    private String problemLink;

    private String status;

    private String adoptionStatus;

    private List<Event> events = new ArrayList<>();

    private JudgeDTO owner;

    private List<Team> workingTeams = new ArrayList<>();
}
