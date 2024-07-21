package com.nucleus.dto;

import com.nucleus.model.hmsmodels.Criteria;
import com.nucleus.model.hmsmodels.Event;
import com.nucleus.model.hmsmodels.Judge;
import com.nucleus.model.hmsmodels.Team;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Component
public class EvaluationEntryDto {

    private Long id;

    private long judgeID;

    private long criteriaID;

    private LocalDate evaluationDate;

    private String remark;

    private Double score;

    private Long teamId;

    private long eventId;
}
