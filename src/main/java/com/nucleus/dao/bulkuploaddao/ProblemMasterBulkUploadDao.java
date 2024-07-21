package com.nucleus.dao.bulkuploaddao;

import com.nucleus.dto.ProblemStatementMasterDto;
import com.nucleus.mapper.ProblemMasterMapper;
import com.nucleus.model.hmsmodels.ProblemStatement;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Repository
public class ProblemMasterBulkUploadDao {
    private SessionFactory sessionFactory;
    private ProblemMasterMapper problemMasterMapper;
    private Logger logger;
    @Autowired
    ProblemMasterBulkUploadDao(SessionFactory sessionFactory, ProblemMasterMapper problemStatementMapper,Logger logger){
        this.problemMasterMapper = problemStatementMapper;
        this.sessionFactory = sessionFactory;
        this.logger = logger;
    }
    @Transactional
    public boolean insertBulkProblems(List<ProblemStatementMasterDto> problemStatementMasterDtos) throws SQLException {
        int rowsAffected = 0;
        if (problemStatementMasterDtos == null || problemStatementMasterDtos.isEmpty()) {
            return false;
        }
        try  {
            Session session = sessionFactory.getCurrentSession();
            List<ProblemStatement> problemStatementMasters = problemMasterMapper.problemStatementDtoToEntityList(problemStatementMasterDtos);
            for (ProblemStatement problemStatementMaster : problemStatementMasters) {
                session.save(problemStatementMaster);
                rowsAffected++;
            }
        } catch (ConstraintViolationException e) {
            logger.error("Unique Constraint Violation while inserting Problem Statments: " + e);
            throw new DataIntegrityViolationException("Unique Constraint Violation! " + e.getMessage(), e);
        } catch (Exception e) {
            logger.error("Error Occurred While Inserting Problem Statements " + e);
            throw new SQLException("Insertion Unsuccessful! Try Again Later", e);
        }
        return rowsAffected > 0;
    }
}
