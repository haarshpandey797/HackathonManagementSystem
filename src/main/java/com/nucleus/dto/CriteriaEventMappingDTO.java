package com.nucleus.dto;

import com.nucleus.model.hmsmodels.Criteria;
import com.nucleus.model.hmsmodels.Event;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CriteriaEventMappingDTO {
    private Long id;
    private Criteria criteria;
    private Event event;
    private int maxScore;
    private int weightage;
}
