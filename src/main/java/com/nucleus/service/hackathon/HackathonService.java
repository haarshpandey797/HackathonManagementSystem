package com.nucleus.service.hackathon;

import com.nucleus.dao.eventDao.EventsDao;
import com.nucleus.dao.judge.JudgeDao;
import com.nucleus.dto.EventDTO;
import com.nucleus.dto.JudgeDTO;
import com.nucleus.dto.JudgeEventMappingDTO;
import com.nucleus.model.hmsmodels.Event;
import com.nucleus.service.judge.JudgeEventMappingService;
import com.nucleus.service.judge.JudgeService;
import com.nucleus.utility.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HackathonService {

    private JudgeService judgeService;
    private EventsDao eventDao;
    private CurrentUser currentUser;
    private JudgeEventMappingService judgeEventMappingService;

    @Autowired
    public HackathonService(JudgeService judgeService, EventsDao eventDao, CurrentUser currentUser, JudgeEventMappingService judgeEventMappingService) {
        this.judgeService = judgeService;
        this.eventDao = eventDao;
        this.currentUser = currentUser;
        this.judgeEventMappingService = judgeEventMappingService;
    }

    public String getOrganiserName(){
        return  currentUser.getCurrentUser();
    }

    public List<Event> getEvent(){
        return eventDao.getEvent();
    }

    public List<Event> getAllEvent(){
        return eventDao.getAllEvents();
    }

    public String saveEvent(Event event){
        if (event==null || eventDao.saveEvent(event).equals("failed")){
            return "unSuccessful";

        }
        else {
            return "successful";
        }

    }

    public boolean addJudgeListToEvent(List<JudgeEventMappingDTO> selectedJudges) {

        EventDTO activeEvent = eventDao.getRunningEvent();
        if (activeEvent == null) {
            return false;
        }

        for (JudgeEventMappingDTO judgeEventMappingDTO : selectedJudges) {
            judgeEventMappingDTO.setEventId(activeEvent.getEventId());

            Long judgeId = judgeEventMappingDTO.getJudgeId();
            judgeEventMappingDTO.setJudgeId(judgeId);

            System.out.println(judgeEventMappingDTO);
            if(!judgeEventMappingService.addJudgeEventMapping(judgeEventMappingDTO))
                return false;

        }
        return true;
    }

    public boolean addProblemListToEvent(List<Long> selectedProblemIds) {
        
        return true;
    }

    public EventDTO getEventById(Long id) {
        return eventDao.getEventById(id);
    }

    public boolean addTeamListToEvent(List<Long> selectedTeamIds) {
        return true;
    }
}
