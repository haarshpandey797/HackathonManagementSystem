package com.nucleus.mapper;


import com.nucleus.dto.EvaluationEntryDto;
import com.nucleus.dto.JudgeDTO;
import com.nucleus.model.hmsmodels.EvaluationEntry;
import com.nucleus.model.hmsmodels.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EvaluationEntryMapper {
    @Autowired
    EventMapper eventMapper;
    @Autowired
    JudgesMappers judgesMappers;
    @Autowired
    CriteriaMapper criteriaMapper;
    @Autowired
    TeamMapper teamMapper;

    // DTO -> Entity
    public EvaluationEntry evaluationEntryDtoToEntity(EvaluationEntryDto dto) {
        EvaluationEntry entity = new EvaluationEntry();
        if (dto == null) return entity;

        entity.setId(dto.getId());
//        entity.setJudge(judgesMappers.judgesMasterDtoToEntity(dto.getJudge()));
//        entity.setCriteria(criteriaMapper.criteriaDtoToEntity(dto.getCriteria()));
        entity.setEvaluationDate(dto.getEvaluationDate());
        entity.setRemark(dto.getRemark());
        entity.setScore(dto.getScore());
//        entity.setTeam(new Team(dto.getTeamId()));
//        entity.setEvent(eventMapper.dtoTOEvent(dto.getEvent()));
        entity.setScore(dto.getScore());

        return entity;
    }

    // List of DTO -> List of Entity
    public List<EvaluationEntry> evaluationEntryDtoToEntityList(List<EvaluationEntryDto> dtos) {
        return dtos.stream()
                .map(this::evaluationEntryDtoToEntity)
                .collect(Collectors.toList());
    }

    // Entity -> DTO
    public EvaluationEntryDto evaluationEntryToDto(EvaluationEntry entity) {
        EvaluationEntryDto dto = new EvaluationEntryDto();
        if (entity == null) return dto;

        dto.setId(entity.getId());
//        dto.setJudge(judgesMappers.judgesMasterToJudgesMasterDto(entity.getJudge()));
//        dto.setCriteria(criteriaMapper.criteriaToCriteriaDto(entity.getCriteria()));
        dto.setEvaluationDate(entity.getEvaluationDate());
        dto.setRemark(entity.getRemark());
        dto.setScore(entity.getScore());
//        dto.setTeamId(entity.getTeam().getTeamId());
//        dto.setEventId(eventMapper.eventToDTO(entity.getEvent()));
        dto.setScore(entity.getScore());
        return dto;
    }

    // List of Entity -> List of DTO
    public List<EvaluationEntryDto> evaluationEntryEntityToDtoList(List<EvaluationEntry> entities) {
        return entities.stream()
                .map(this::evaluationEntryToDto)
                .collect(Collectors.toList());
    }
}
