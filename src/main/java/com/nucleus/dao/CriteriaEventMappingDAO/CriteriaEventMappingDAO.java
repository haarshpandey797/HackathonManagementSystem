package com.nucleus.dao.CriteriaEventMappingDAO;

import com.nucleus.dao.judge.JudgeDao;
import com.nucleus.dto.CriteriaEventMappingDTO;
import com.nucleus.dto.JudgeDTO;
import com.nucleus.mapper.CriteriaEventMappingMapper;
import com.nucleus.model.hmsmodels.CriteriaEventMapping;
import com.nucleus.model.hmsmodels.Judge;
import org.apache.logging.log4j.LogManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class CriteriaEventMappingDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CriteriaEventMappingDTO criteriaEventMappingDTO;


    @Autowired
    private CriteriaEventMappingMapper criteriaEventMappingMapper;

    public List<CriteriaEventMappingDTO> getAllCriteriaEventMapping(long eventId) {
        try {
            Session session = sessionFactory.getCurrentSession();
            return session.createQuery("FROM CriteriaEventMapping where event.eventId="+eventId, CriteriaEventMapping.class)
                    .getResultList()
                    .stream()
                    .map(criteriaEventMappingMapper::criteriaEventMappingToCriteriaEventMappingDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            LogManager.getLogger(JudgeDao.class).error("Error fetching CriteriaEventMapping: {}", e.getMessage());
            return Collections.emptyList();
        }
    }
}
