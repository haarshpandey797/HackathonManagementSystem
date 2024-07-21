package com.nucleus.dao.bulkuploaddao;

import com.nucleus.dto.JudgeDTO;
import com.nucleus.mapper.JudgesMappers;
import com.nucleus.model.hmsmodels.Judge;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class JudgesBulkUploadDao {
    SessionFactory sessionFactory;
    JudgesMappers judgesMappers;
    Logger logger;
    @Autowired
    public JudgesBulkUploadDao(SessionFactory sessionFactory,JudgesMappers judgesMappers,Logger logger){
        this.logger = logger;
        this.judgesMappers = judgesMappers;
        this.sessionFactory = sessionFactory;
    }

    // Function to insert List of Judges into the DB
    public boolean insertBulkJudges(List<JudgeDTO> judgesDtoList) throws HibernateException,SQLException {
        int rowsAffected = 0;
        if (judgesDtoList == null || judgesDtoList.isEmpty()) {
            return false;
        }
        try{
            Session session = sessionFactory.getCurrentSession();
            List<Judge> judgesMasterList = judgesMappers.judgesMasterDtoToEntityList(judgesDtoList);
            for (Judge judge : judgesMasterList) {
                session.save(judge);
                rowsAffected++;
            }
        }
        catch (ConstraintViolationException e) {
            logger.error("Unique Constraint Violation while inserting Judges: " + e);
            throw new DataIntegrityViolationException("Unique Constraint Violation! " + e.getMessage(), e);
        } catch (Exception e) {
            logger.error("Error Occurred While Inserting Judges " + e);
            throw new SQLException("Insertion Unsuccessful! Try Again Later", e);
        }

        return rowsAffected > 0;
    }

    public JudgeDTO getJudgeMasterDto(long judgeId){
        JudgeDTO judgesMasterDto = new JudgeDTO();
        if(judgeId < 0 ) return judgesMasterDto;
        try{
            Session session = sessionFactory.getCurrentSession();
            // Getting the Judge from the Judge Table (Judge Master)
            Judge judgesMaster = session.get(Judge.class,judgeId);
            // Converting the Judge Master to the Judge Dto
            judgesMasterDto = judgesMappers.judgesMasterToJudgesMasterDto(judgesMaster);
        }catch (HibernateException he){
            he.printStackTrace();
        }
        return judgesMasterDto;
    }
}
