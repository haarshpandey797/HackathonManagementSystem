package com.nucleus.service.criteria;

import com.nucleus.dao.criteria.CriteriaDao;
import com.nucleus.dto.CriteriaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CriteriaService {
    @Autowired
    CriteriaDao criteriaDao;
    public CriteriaDTO getCriteriaFromCriteriaName(String criteriaName){
        return criteriaDao.getCriteriaFromCriteriaName(criteriaName);
    }
}
