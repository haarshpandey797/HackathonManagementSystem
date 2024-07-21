package com.nucleus.service.problemstatementservice;

import com.nucleus.dao.problemstatementdao.ProblemStatementDao;
import com.nucleus.dto.ProblemStatementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProblemStatementService {
    @Autowired
    ProblemStatementDao problemStatementDao;
    public List<ProblemStatementDTO> getAllProblems(){
        return problemStatementDao.getAllProblems();
    }
}
