package com.nucleus.mapper;

import com.nucleus.dto.CriteriaEventMappingDTO;
import com.nucleus.model.hmsmodels.CriteriaEventMapping;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CriteriaEventMappingMapper {

    // DTO -> Entity
    public CriteriaEventMapping criteriaEventMappingDtoToEntity(CriteriaEventMappingDTO criteriaEventMappingDTO) {
        CriteriaEventMapping criteriaEventMapping = new CriteriaEventMapping();
        if(criteriaEventMappingDTO == null) return criteriaEventMapping;
        criteriaEventMapping.setId(criteriaEventMappingDTO.getId());
        criteriaEventMapping.setCriteria(criteriaEventMappingDTO.getCriteria());
        criteriaEventMapping.setEvent(criteriaEventMappingDTO.getEvent());
        criteriaEventMapping.setMaxScore(criteriaEventMappingDTO.getMaxScore());
        criteriaEventMapping.setWeightage(criteriaEventMappingDTO.getWeightage());
        return criteriaEventMapping;
    }

    // List of DTO -> List of Entity
    public List<CriteriaEventMapping> criteriaEventMappingDtoToEntityList(List<CriteriaEventMappingDTO> criteriaEventMappingDTOs) {
        if( criteriaEventMappingDTOs == null || criteriaEventMappingDTOs.isEmpty()) return new ArrayList<>();
        return criteriaEventMappingDTOs.stream()
                .map(this::criteriaEventMappingDtoToEntity)
                .collect(Collectors.toList());
    }

    // Entity -> DTO
    public CriteriaEventMappingDTO criteriaEventMappingToCriteriaEventMappingDto(CriteriaEventMapping criteriaEventMapping) {
        CriteriaEventMappingDTO criteriaEventMappingDTO = new CriteriaEventMappingDTO();
        if(criteriaEventMapping == null) return criteriaEventMappingDTO;
        criteriaEventMappingDTO.setId(criteriaEventMapping.getId());
        criteriaEventMappingDTO.setCriteria(criteriaEventMapping.getCriteria());
        criteriaEventMappingDTO.setEvent(criteriaEventMapping.getEvent());
        criteriaEventMappingDTO.setMaxScore(criteriaEventMapping.getMaxScore());
        criteriaEventMappingDTO.setWeightage(criteriaEventMapping.getWeightage());
        return criteriaEventMappingDTO;
    }

    // List of Entity -> List of DTO
    public List<CriteriaEventMappingDTO> criteriaEventMappingEntityToDTOList(List<CriteriaEventMapping> criteriaEventMappings) {
        if(criteriaEventMappings == null || criteriaEventMappings.isEmpty()) return new ArrayList<>();
        return criteriaEventMappings.stream()
                .map(this::criteriaEventMappingToCriteriaEventMappingDto)
                .collect(Collectors.toList());
    }
}
