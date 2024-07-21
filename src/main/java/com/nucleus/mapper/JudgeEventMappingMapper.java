package com.nucleus.mapper;

import com.nucleus.dto.EventDTO;
import com.nucleus.dto.JudgeDTO;
import com.nucleus.dto.JudgeEventMappingDTO;
import com.nucleus.model.extra.JudgeEventMappingId;
import com.nucleus.model.hmsmodels.Event;
import com.nucleus.model.hmsmodels.Judge;
import com.nucleus.model.hmsmodels.JudgeEventMapping;
import com.nucleus.service.hackathon.HackathonService;
import com.nucleus.service.judge.JudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JudgeEventMappingMapper {

    private JudgesMappers judgeMapper;

    private EventMapper eventMapper;

    @Autowired
    public JudgeEventMappingMapper(JudgesMappers judgeMapper, EventMapper eventMapper) {
        this.judgeMapper = judgeMapper;
        this.eventMapper = eventMapper;
    }

    public JudgeEventMapping dtoToEntity(JudgeEventMappingDTO judgeEventMappingDTO) {
        JudgeEventMapping judgeEventMapping = new JudgeEventMapping();

        judgeEventMapping.setId(new JudgeEventMappingId(judgeEventMappingDTO.getEventId(), judgeEventMappingDTO.getJudgeId()));

        judgeEventMapping.setJudge(new Judge(judgeEventMappingDTO.getJudgeId()));
        judgeEventMapping.setEvent(new Event(judgeEventMappingDTO.getEventId()));

        judgeEventMapping.setRole(judgeEventMappingDTO.getRole());
        judgeEventMapping.setResponsibility(judgeEventMappingDTO.getResponsibility());

        return judgeEventMapping;
    }
}
