package com.nucleus.mapper;

import com.nucleus.dto.ProblemStatementDTO;
import com.nucleus.model.hmsmodels.ProblemStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProblemStatementMapper {
    JudgesMappers judgesMappers;
    @Autowired
    public ProblemStatementMapper(JudgesMappers judgesMappers){
        this.judgesMappers = judgesMappers;
    }
    public ProblemStatementDTO entityToDto(ProblemStatement problemStatement){
        ProblemStatementDTO problemStatementDTO=new ProblemStatementDTO();

        problemStatementDTO.setProblemStatementId(problemStatement.getProblemStatementId());
        problemStatementDTO.setProblemDescription(problemStatement.getProblemDescription());
        problemStatementDTO.setProblemLink(problemStatement.getProblemLink());
        problemStatementDTO.setProblemName(problemStatement.getProblemName());
        problemStatementDTO.setEvents(problemStatement.getEvents());
        problemStatementDTO.setAdoptionStatus(problemStatement.getAdoptionStatus());
        problemStatementDTO.setOwner(judgesMappers.judgesMasterToJudgesMasterDto(problemStatement.getOwner()));
        problemStatementDTO.setStatus(problemStatement.getStatus());
        problemStatementDTO.setWorkingTeams(problemStatement.getWorkingTeams());
        problemStatementDTO.setProblemStatementId(problemStatement.getProblemStatementId());
        return problemStatementDTO;
    }
    // Dto -> ENtity
    public ProblemStatement dtoTOEntity(ProblemStatementDTO problemStatementDTO){
        ProblemStatement problemStatement=new ProblemStatement();

        problemStatement.setProblemStatementId(problemStatementDTO.getProblemStatementId());
        problemStatement.setProblemDescription(problemStatementDTO.getProblemDescription());
        problemStatement.setProblemLink(problemStatementDTO.getProblemLink());
        problemStatement.setProblemName(problemStatementDTO.getProblemName());
        problemStatement.setEvents(problemStatementDTO.getEvents());
        problemStatement.setAdoptionStatus(problemStatementDTO.getAdoptionStatus());
        problemStatement.setOwner(judgesMappers.judgesMasterDtoToEntity(problemStatementDTO.getOwner()));
        problemStatement.setStatus(problemStatementDTO.getStatus());
        problemStatement.setWorkingTeams(problemStatementDTO.getWorkingTeams());
        problemStatement.setProblemStatementId(problemStatementDTO.getProblemStatementId());
        return problemStatement;
    }
}
