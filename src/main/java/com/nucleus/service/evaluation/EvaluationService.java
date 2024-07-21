package com.nucleus.service.evaluation;

import com.nucleus.dao.evaluation.EvaluationDao;
import com.nucleus.dto.*;
import com.nucleus.service.criteria.CriteriaService;
import com.nucleus.service.judge.JudgeService;

import com.nucleus.service.team.TeamService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EvaluationService {
    @Autowired
    EvaluationDao evaluationDao;
    @Autowired
    JudgeService judgeService;
    @Autowired
    JudgeDTO judgeDTO;
    @Autowired
    EventDTO eventDTO;
    @Autowired
    TeamService teamService;
    @Autowired
    CriteriaDTO criteriaDTO;
    @Autowired
    CriteriaService criteriaService;
    @Autowired
    Logger logger;

    @Transactional
    public List<CriteriaDTO> showCriterias(long id) {
        return evaluationDao.getAllCriteria(id);
    }

    @Transactional
    public List<TeamDto> showTeams(long id) {
        return evaluationDao.getAllTeams(id);
    }

    @Transactional
    public boolean processAndStoreResults(List<List<String>> scores) {
        if (scores.isEmpty()) {
            return false;
        }
        boolean isEvaluation = true;
        for (List<String> score : scores)
            isEvaluation = makeEvaluationObj(score) && isEvaluation;
        return isEvaluation;
    }

    public Map<String, Integer> getTotalScores(Map<String, Integer> teamTotalScores) {
        return new HashMap<>(teamTotalScores);
    }

    public boolean makeEvaluationObj(List<String> score) {
        EvaluationEntryDto evaluationEntryDto = new EvaluationEntryDto();

        evaluationEntryDto.setEvaluationDate(LocalDate.now());
        evaluationEntryDto.setJudgeID(judgeService.getJudge().getJudgeId());
        evaluationEntryDto.setCriteriaID(criteriaService.getCriteriaFromCriteriaName(score.get(1)).getCriteriaId());
        evaluationEntryDto.setEventId(judgeService.getEvents().getEventId());
        evaluationEntryDto.setTeamId(teamService.getTeamsByTeamName(score.get(0)).getTeamId());
        evaluationEntryDto.setScore(Double.valueOf(score.get(2)));

        return evaluationDao.saveEvaluations(evaluationEntryDto);
    }
}

