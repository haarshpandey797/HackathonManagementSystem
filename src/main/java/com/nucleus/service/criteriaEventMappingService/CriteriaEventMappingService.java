package com.nucleus.service.criteriaEventMappingService;


import com.nucleus.dao.CriteriaEventMappingDAO.CriteriaEventMappingDAO;
import com.nucleus.dto.CriteriaEventMappingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CriteriaEventMappingService {


    @Autowired
    private CriteriaEventMappingDAO criteriaEventMappingDAO;


    public List<CriteriaEventMappingDTO> getAllCriteriaForAEvent(long eventID){
        return criteriaEventMappingDAO.getAllCriteriaEventMapping( eventID);
    }
}
