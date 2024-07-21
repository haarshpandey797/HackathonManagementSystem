package com.nucleus.service.judge;

import com.nucleus.dao.judge.JudgeEventMappingDAO;
import com.nucleus.dto.JudgeEventMappingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JudgeEventMappingService {

    private JudgeEventMappingDAO judgeEventMappingDAO;

    @Autowired
    public JudgeEventMappingService(JudgeEventMappingDAO judgeEventMappingDAO) {
        this.judgeEventMappingDAO = judgeEventMappingDAO;
    }

    @Transactional(readOnly = true)
    public boolean addJudgeEventMapping(JudgeEventMappingDTO judgeEventMappingDTO) {
        return judgeEventMappingDAO.addJudgeEventMapping(judgeEventMappingDTO);
    }
}
