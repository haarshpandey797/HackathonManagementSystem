package com.nucleus.dao.criteria;

import com.nucleus.dto.CriteriaDTO;
import com.nucleus.mapper.CriteriaMapper;
import com.nucleus.mapper.TeamMapper;
import com.nucleus.model.hmsmodels.Criteria;
import com.nucleus.model.hmsmodels.Team;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CriteriaDao {
    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    CriteriaMapper criteriaMapper;
     public CriteriaDTO getCriteriaFromCriteriaName(String criteriaName) {
        Session session = sessionFactory.getCurrentSession();
        String queryStr = "SELECT c FROM Criteria c WHERE criteriaName = :name";
        Query query = session.createQuery(queryStr, Criteria.class);
        query.setParameter("name", criteriaName);

        Criteria criteria = (Criteria) query.getSingleResult();
        if (criteria != null) {
            return criteriaMapper.criteriaToCriteriaDto(criteria);
        } else {
            // Handle case where no criteria with the given name is found
            return null; // or throw an exception, depending on your application logic
        }
    }

}
