package com.nucleus.mapper;

import com.nucleus.dto.ProblemStatementMasterDto;
import com.nucleus.model.hmsmodels.ProblemStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProblemMasterMapper {
    JudgesMappers judgesMappers;
    @Autowired
    ProblemMasterMapper(JudgesMappers judgesMappers){
        this.judgesMappers = judgesMappers;
    }
    //Problem Statement Dto -> Entity
    public ProblemStatement problemStatementDtoToEntity(ProblemStatementMasterDto dto) {
        ProblemStatement entity = new ProblemStatement();
        if (dto == null) return entity;

        entity.setProblemName(dto.getProblemName());
        entity.setProblemDescription(dto.getProblemDescription());
        if (dto.getOwner() != null) entity.setOwner(judgesMappers.judgesMasterDtoToEntity(dto.getOwner()));
        entity.setStatus(dto.getStatus());
        entity.setProblemLink(dto.getProblemLink());
        entity.setAdoptionStatus(dto.getAdoptionStatus());

        return entity;
    }
    // Dto List -> entity
    public List<ProblemStatement> problemStatementDtoToEntityList(List<ProblemStatementMasterDto> dtos) {
        return dtos.stream()
                .map(this::problemStatementDtoToEntity)
                .collect(Collectors.toList());
    }
}
