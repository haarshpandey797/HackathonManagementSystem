package com.nucleus.mapper;

import com.nucleus.dto.CriteriaDTO;
import com.nucleus.model.hmsmodels.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CriteriaMapper {
    private CriteriaEventMappingMapper criteriaEventMappingMapper;
    @Autowired
    public CriteriaMapper(CriteriaEventMappingMapper criteriaEventMappingMapper){
        this.criteriaEventMappingMapper = criteriaEventMappingMapper;
    }

    // DTO -> Entity
    public Criteria criteriaDtoToEntity(CriteriaDTO criteriaDTO){
        Criteria criteria = new Criteria();
        if(criteriaDTO == null) return criteria;
        criteria.setCriteriaId(criteriaDTO.getCriteriaId());
        criteria.setCriteriaName(criteriaDTO.getCriteriaName());
        criteria.setDescription(criteriaDTO.getDescription());
        criteria.setStatus(criteriaDTO.getStatus());
        criteria.setCategory(criteriaDTO.getCategory());
        criteria.setCriteriaEventMappings(criteriaEventMappingMapper.criteriaEventMappingDtoToEntityList(criteriaDTO.getCriteriaEventMappings()));
        return criteria;
    }

    // List of DTO -> List of Entity
    public List<Criteria> criteriaDtoToEntityList(List<CriteriaDTO> criteriaDTOs ){
        return criteriaDTOs.stream()
                .map(this::criteriaDtoToEntity)
                .collect(Collectors.toList());
    }

    // Entity -> DTO
    public  CriteriaDTO criteriaToCriteriaDto(Criteria criteria){
        CriteriaDTO criteriaDTO = new CriteriaDTO();
        if(criteria == null) return criteriaDTO;
        criteriaDTO.setCriteriaId(criteria.getCriteriaId());
        criteriaDTO.setCriteriaName(criteria.getCriteriaName());
        criteriaDTO.setDescription(criteria.getDescription());
        criteriaDTO.setStatus(criteria.getStatus());
        criteriaDTO.setCategory(criteria.getCategory());
        criteriaDTO.setCriteriaEventMappings(criteriaEventMappingMapper.criteriaEventMappingEntityToDTOList(criteria.getCriteriaEventMappings()));
        return criteriaDTO;
    }

    // List of Entity -> List of DTO
    public List<CriteriaDTO> criteriaEntityToDTOList(List<Criteria> criteriaList ){
        return criteriaList.stream()
                .map(this::criteriaToCriteriaDto)
                .collect(Collectors.toList());
    }
}
