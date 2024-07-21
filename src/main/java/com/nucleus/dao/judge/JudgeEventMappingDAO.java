package com.nucleus.dao.judge;

import com.nucleus.dto.JudgeEventMappingDTO;
import com.nucleus.mapper.JudgeEventMappingMapper;
import org.apache.logging.log4j.LogManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JudgeEventMappingDAO {

    private JudgeEventMappingMapper judgeEventMappingMapper;

    private SessionFactory sessionFactory;

    @Autowired
    public JudgeEventMappingDAO(JudgeEventMappingMapper judgeEventMappingMapper, SessionFactory sessionFactory) {
        this.judgeEventMappingMapper = judgeEventMappingMapper;
        this.sessionFactory = sessionFactory;
    }

    public boolean addJudgeEventMapping(JudgeEventMappingDTO judgeEventMappingDTO) {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.save(judgeEventMappingMapper.dtoToEntity(judgeEventMappingDTO));
            return true;
        } catch (Exception e) {
//            LogManager.getLogger(JudgeEventMappingDAO.class).error("Error inserting JudgeEventMapping: {}", e.printStackTrace());
            e.printStackTrace();
            return false;
        }
    }


}
