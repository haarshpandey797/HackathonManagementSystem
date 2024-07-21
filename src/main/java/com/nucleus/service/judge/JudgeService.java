package com.nucleus.service.judge;

import com.nucleus.dao.eventDao.EventsDao;
import com.nucleus.dao.judge.JudgeDao;
import com.nucleus.dto.EventDTO;

import com.nucleus.dto.JudgeDTO;

import com.nucleus.dto.ProblemStatementDTO;
import com.nucleus.mapper.EventMapper;


import com.nucleus.mapper.JudgesMappers;
import com.nucleus.utility.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JudgeService {
    @Autowired
    JudgeDao judgeDao;
    @Autowired
    EventMapper eventMapper;
    @Autowired
    JudgesMappers judgesMappers;
    @Autowired
    CurrentUser currentUser;
    @Autowired
    EventDTO eventsMasterDTO;
    @Autowired
    EventsDao eventsDao;

    public JudgeDTO getJudge(){

        return judgeDao.getLoggedInJudge(Long.parseLong(currentUser.getCurrentUser()));
    }

    @Transactional(readOnly = true)
    public List<JudgeDTO> getAllJudges() {
        List<JudgeDTO> judges=judgeDao.getAllJudges();
        return judges;
    }

    public void saveJudge(JudgeDTO judgeDto){
//        judgeDao.save(judgeDto);
    }

    @Transactional(readOnly = true)
    public EventDTO getEvents(){
        EventDTO eventDTO=null;
        try {
            long employeeId = Long.parseLong(currentUser.getCurrentUser());
            if(judgeDao.isJudgeInActiveEvent(employeeId)) {
                eventDTO = eventsDao.getRunningEvent();
            }
        }
        catch(NumberFormatException ex){
            ex.printStackTrace();
        }
        return eventDTO;
    }
    @Transactional
    public JudgeDTO getJudgeById(long id){
        return judgeDao.getJudgeById(id);
    }

    @Transactional
    public List<ProblemStatementDTO> showProblems(long id){
        return judgeDao.getProblems(id);
    }
}
