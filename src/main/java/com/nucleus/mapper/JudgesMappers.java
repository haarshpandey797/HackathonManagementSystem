package com.nucleus.mapper;

import com.nucleus.dto.JudgeDTO;
import com.nucleus.model.hmsmodels.Judge;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JudgesMappers {

    // DTO -> Entity
    public Judge judgesMasterDtoToEntity(JudgeDTO judgesMasterDto){
        Judge judgesMaster = new Judge();
        if(judgesMasterDto == null) return judgesMaster;
        judgesMaster.setJudgeId(judgesMasterDto.getJudgeId());
        judgesMaster.setJudgeName(judgesMasterDto.getJudgeName());
        judgesMaster.setJudgeBU(judgesMasterDto.getJudgeBU());
        judgesMaster.setJudgeContactNo(judgesMasterDto.getJudgeContactNo());
        judgesMaster.setJudgeEmail(judgesMasterDto.getJudgeEmail());
        judgesMaster.setJudgeDesignation(judgesMasterDto.getJudgeDesignation());
        judgesMaster.setJudgeEmployeeId(judgesMasterDto.getJudgeEmployeeId());
        return judgesMaster;
    }

    // List of DTO -> List of Entity
    public List<Judge> judgesMasterDtoToEntityList(List<JudgeDTO> judgesMasterDtos ){
        return judgesMasterDtos.stream()
                .map(this::judgesMasterDtoToEntity)
                .collect(Collectors.toList());
    }

    // Entity -> DTO
   public JudgeDTO judgesMasterToJudgesMasterDto(Judge judgeMaster ){
       JudgeDTO judgesMasterDto = new JudgeDTO();
       if(judgeMaster == null) return judgesMasterDto;
       judgesMasterDto.setJudgeId(judgeMaster.getJudgeId());
       judgesMasterDto.setJudgeName(judgeMaster.getJudgeName());
       judgesMasterDto.setJudgeBU(judgeMaster.getJudgeBU());
       judgesMasterDto.setJudgeContactNo(judgeMaster.getJudgeContactNo());
       judgesMasterDto.setJudgeEmail(judgeMaster.getJudgeEmail());
       judgesMasterDto.setJudgeDesignation(judgeMaster.getJudgeDesignation());
       judgesMasterDto.setJudgeEmployeeId(judgeMaster.getJudgeEmployeeId());
       return judgesMasterDto;
    }

    // List of Entity -> List of DTO
    public List<JudgeDTO> judgesMasterEntityToDTO(List<Judge> judgesMasters ){
        return judgesMasters.stream()
                .map(this::judgesMasterToJudgesMasterDto)
                .collect(Collectors.toList());
    }
}
