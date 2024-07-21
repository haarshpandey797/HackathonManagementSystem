package com.nucleus.dao.bulkuploaddao;

import com.nucleus.dto.CriteriaDTO;
import com.nucleus.mapper.CriteriaMapper;
import com.nucleus.model.hmsmodels.Criteria;
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
public class CriteriaBulkUploadDao {

    private final SessionFactory sessionFactory;
    private final CriteriaMapper criteriaMapper;
    private final Logger logger;

    @Autowired
    public CriteriaBulkUploadDao(SessionFactory sessionFactory, CriteriaMapper criteriaMapper, Logger logger) {
        this.sessionFactory = sessionFactory;
        this.criteriaMapper = criteriaMapper;
        this.logger = logger;
    }

    // Function to insert List of Criteria into the DB
    public boolean insertBulkCriteria(List<CriteriaDTO> criteriaDtoList) throws SQLException {
        int rowsAffected = 0;
        if (criteriaDtoList == null || criteriaDtoList.isEmpty()) {
            return false;
        }
        try {
            Session session = sessionFactory.getCurrentSession();
            List<Criteria> criteriaList = criteriaMapper.criteriaDtoToEntityList(criteriaDtoList);
            for (Criteria criteria : criteriaList) {
                session.save(criteria);
                rowsAffected++;
            }
        } catch (ConstraintViolationException e) {
            logger.error("Unique Constraint Violation while inserting Criteria: " + e);
            throw new DataIntegrityViolationException("Unique Constraint Violation! " + e.getMessage(), e);
        } catch (Exception e) {
            logger.error("Error Occurred While Inserting Criteria " + e);
            throw new SQLException("Insertion Unsuccessful! Try Again Later", e);
        }
        return rowsAffected > 0;
    }

    public CriteriaDTO getCriteriaDto(int criteriaId) {
        CriteriaDTO criteriaDto = new CriteriaDTO();
        if (criteriaId < 0) return criteriaDto;
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.get(Criteria.class, criteriaId);
            criteriaDto = criteriaMapper.criteriaToCriteriaDto(criteria);
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return criteriaDto;
    }
}
