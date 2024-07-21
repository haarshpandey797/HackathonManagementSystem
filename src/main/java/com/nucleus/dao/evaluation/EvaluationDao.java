package com.nucleus.dao.evaluation;


//import com.nucleus.dto.CriteriaDto;
import com.nucleus.dto.CriteriaDTO;
import com.nucleus.dto.EvaluationEntryDto;
import com.nucleus.dto.TeamDto;
import com.nucleus.mapper.*;
import com.nucleus.model.hmsmodels.*;
import com.nucleus.model.hmsmodels.Criteria;
import com.nucleus.service.judge.JudgeService;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EvaluationDao{

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    JudgesMappers judgesMappers;
   @Autowired
   EventMapper eventMapper;
    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private CriteriaMapper criteriaMapper;
    @Autowired
    EvaluationEntryMapper evaluationEntryMapper;
    @Autowired
    Logger logger;
    @Autowired
    JudgeService judgeService;

    @SuppressWarnings("unchecked")
    public List<CriteriaDTO> getAllCriteria(long id) {
        String hql = "SELECT c FROM Criteria c JOIN FETCH c.criteriaEventMappings m WHERE m.event.eventId = :eventId";
        TypedQuery<Criteria> query = sessionFactory.getCurrentSession().createQuery(hql, Criteria.class);
        query.setParameter("eventId", id);

        List<Criteria> criteriaList = query.getResultList();
        return criteriaList.stream()
                .map(criteriaMapper::criteriaToCriteriaDto)
                .collect(Collectors.toList());
    }

    @SuppressWarnings("unchecked")
    public List<TeamDto> getAllTeams(long id) {
        List<Team> teamList = sessionFactory.getCurrentSession().createQuery("FROM Team where event_id="+id).list();
        return teamList.stream()
                .map(teamMapper::teamToDto)
                .collect(Collectors.toList());
    }

    public boolean saveEvaluations(EvaluationEntryDto evaluationEntryDto) {
        try {
            Session session = sessionFactory.getCurrentSession();
            // Convert DTO to entity
            EvaluationEntry evaluationEntry = evaluationEntryMapper.evaluationEntryDtoToEntity(evaluationEntryDto);
            // Ensure Event is properly managed or fetched
            evaluationEntry.setTeam(session.get(Team.class,evaluationEntryDto.getTeamId()));
            evaluationEntry.setJudge(session.get(Judge.class,evaluationEntryDto.getJudgeID()));
            evaluationEntry.setCriteria(session.get(Criteria.class,evaluationEntryDto.getCriteriaID()));
            evaluationEntry.setEvent(session.get(Event.class,evaluationEntryDto.getEventId()));

            session.save(evaluationEntry); // Save the entity
            return true;
        } catch (HibernateException ex) {
            logger.warn("The evaluation was not saved");
            ex.printStackTrace();
            return false;
        }
    }


}
