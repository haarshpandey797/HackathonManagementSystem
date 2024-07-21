package com.nucleus.dto;

import com.nucleus.model.hmsmodels.EventOrganiserMapping;
import com.nucleus.model.hmsmodels.ProblemStatement;
import com.nucleus.model.hmsmodels.Team;
import com.nucleus.model.hmsmodels.CriteriaEventMapping;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Data
public class EventDTO {

        private Long eventId;
        private String eventName;
        private LocalDate startDate;
        private LocalDate endDate;
        private String location;
        private String description;
        private String eventType = "in-person";
        private String theme;
        private Integer plannedHours;
        private String scheduleLink;
        private Integer approvedBudget;
        private List<ProblemStatement> problemStatements;
        private List<EventOrganiserMapping> organiserMappings = new ArrayList<>();

        private Set<JudgeEventMappingDTO> judgeMappings = new HashSet<>();

        private List<Team> teamList;
        private List<CriteriaEventMapping> criteriaEventMappings;
        private Boolean activeInactiveStatus;
        private String comment;

}


