package com.nucleus.dao.problemstatementdao;

import com.nucleus.dao.judge.JudgeDao;
import com.nucleus.dto.ProblemStatementDTO;
import com.nucleus.mapper.ProblemMasterMapper;
import com.nucleus.mapper.ProblemStatementMapper;
import com.nucleus.model.hmsmodels.Judge;
import com.nucleus.model.hmsmodels.ProblemStatement;
import org.apache.logging.log4j.LogManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProblemStatementDao {
    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    ProblemStatementMapper problemStatementMapper;
    public List<ProblemStatementDTO> getAllProblems(){
        try {
            Session session = sessionFactory.getCurrentSession();
            return session.createQuery("FROM ProblemStatement", ProblemStatement.class)
                    .getResultList()
                    .stream()
                    .map(problemStatementMapper::entityToDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            LogManager.getLogger(ProblemStatementDao.class).error("Error fetching Problem Statements: {}", e.getMessage());
            return Collections.emptyList();
        }
    }
}
