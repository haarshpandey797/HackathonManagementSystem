package com.nucleus.dao.judge;


import com.nucleus.dao.eventDao.EventsDao;
import com.nucleus.dto.EventDTO;
import com.nucleus.dto.JudgeDTO;
import com.nucleus.dto.ProblemStatementDTO;
import com.nucleus.mapper.EventMapper;
import com.nucleus.mapper.JudgesMappers;
import com.nucleus.mapper.ProblemStatementMapper;
import com.nucleus.model.hmsmodels.*;
import com.nucleus.model.hmsmodels.Judge;
import com.nucleus.model.hmsmodels.JudgeEventMapping;
import com.nucleus.utility.CurrentUser;
import org.apache.logging.log4j.LogManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Repository
public class JudgeDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private CurrentUser currentUser;
    @Autowired
    private JudgesMappers judgeMapper;
    @Autowired
    EventMapper eventMapper;
    @Autowired
    ProblemStatementMapper problemStatementMapper;


    public boolean isJudgeInActiveEvent(Long employeeId) {
        try {
            Session session = sessionFactory.getCurrentSession();
            TypedQuery<Judge> query = session.createQuery("FROM Judge WHERE judgeEmployeeId = :employeeId", Judge.class);
            query.setParameter("employeeId", employeeId);
            Judge judge = query.getSingleResult();
            List<JudgeEventMapping> judgeEventMappings = judge.getJudgeEventMappings();
            for (JudgeEventMapping judgeEventMapping : judgeEventMappings) {
                if (judgeEventMapping.getEvent().getActiveInactiveStatus().equals(Boolean.TRUE))
                    return true;
            }
        } catch (HibernateException e) {
            LogManager.getLogger(EventsDao.class).error("Error fetching Judge: {}", e.getMessage());
        }
        return false;
    }

    public JudgeDTO getJudgeById(long id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            return judgeMapper.judgesMasterToJudgesMasterDto(session.get(Judge.class, id));
        } catch (Exception e) {
            LogManager.getLogger(JudgeDao.class).error("Error fetching Judge: {}", e.getMessage());
            return null;
        }
    }
    public JudgeDTO getLoggedInJudge(long empId){
        Judge judge=null;
        try {
            Session session = sessionFactory.getCurrentSession();
            judge = session.createQuery("from Judge where judgeEmployeeId=:judgeEmployeeId", Judge.class).setParameter("judgeEmployeeId", empId).getSingleResult();
            return judgeMapper.judgesMasterToJudgesMasterDto(judge);

        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;

        }

    }
    public List<JudgeDTO> getAllJudges() {
        try {
            Session session = sessionFactory.getCurrentSession();
            return session.createQuery("FROM Judge", Judge.class)
                    .getResultList()
                    .stream()
                    .map(judgeMapper::judgesMasterToJudgesMasterDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            LogManager.getLogger(JudgeDao.class).error("Error fetching Judges: {}", e.getMessage());
            return Collections.emptyList();
        }
    }
    public List<ProblemStatementDTO> getProblems(long id){
        String hql = "SELECT p FROM ProblemStatement p JOIN FETCH p.events m WHERE m.eventId = :eventId";
        TypedQuery<ProblemStatement> query = sessionFactory.getCurrentSession().createQuery(hql, ProblemStatement.class);
        query.setParameter("eventId", id);

        List<ProblemStatement> problems = query.getResultList();
        return problems.stream()
                .map(problemStatementMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
