package com.nucleus.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class CriteriaDTO {
    private Long criteriaId;
    private String criteriaName;
    private String description;
    private String status;
    private String category;
    private List<CriteriaEventMappingDTO> criteriaEventMappings;
}
