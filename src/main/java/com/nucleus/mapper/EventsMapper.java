//package com.nucleus.mapper;
//
//import com.nucleus.dto.EventsMasterDTO;
//import com.nucleus.model.hmsmodels.EventsMaster;
//import org.springframework.stereotype.Component;
//
//@Component
//public class EventsMapper {
//    public EventsMaster dtoTOEntity(EventsMasterDTO eventsMasterDTO){
//        EventsMaster eventsMaster=new EventsMaster();
//        eventsMaster.setEventId(eventsMasterDTO.getEventId());
//        eventsMaster.setEventName(eventsMasterDTO.getEventName());
//        eventsMaster.setApprovedBudget(eventsMasterDTO.getApprovedBudget());
//        eventsMaster.setCriteriaMasterList(eventsMasterDTO.getCriteriaMasterList());
//        eventsMaster.setDescription(eventsMasterDTO.getDescription());
//        eventsMaster.setLocation(eventsMasterDTO.getLocation());
//        eventsMaster.setPlannedHours(eventsMasterDTO.getPlannedHours());
//        eventsMaster.setCriteriaMasterList(eventsMasterDTO.getCriteriaMasterList());
//        eventsMaster.setEndDate(eventsMasterDTO.getEndDate());
//        eventsMaster.setScheduleLink(eventsMasterDTO.getScheduleLink());
//        eventsMaster.setType(eventsMasterDTO.getType());
//        eventsMaster.setJudgePanel(eventsMasterDTO.getJudgePanel());
//        eventsMaster.setTheme(eventsMasterDTO.getTheme());
//        eventsMaster.setStartDate(eventsMasterDTO.getStartDate());
//        eventsMaster.setOrganisingTeam(eventsMasterDTO.getOrganisingTeam());
//        eventsMaster.setProblemList(eventsMasterDTO.getProblemList());
//        eventsMaster.setTeamScoreCards(eventsMasterDTO.getTeamScoreCards());
//        eventsMaster.setTeamScoreSheets(eventsMasterDTO.getTeamScoreSheets());
//    return eventsMaster;
//    }
//    public EventsMasterDTO entityTODTO(EventsMaster eventsMaster){
//        EventsMasterDTO eventsMasterDTO=new EventsMasterDTO();
//        eventsMasterDTO.setEventId(eventsMaster.getEventId());
//        eventsMasterDTO.setEventName(eventsMaster.getEventName());
//        eventsMasterDTO.setApprovedBudget(eventsMaster.getApprovedBudget());
//        eventsMasterDTO.setCriteriaMasterList(eventsMaster.getCriteriaMasterList());
//        eventsMasterDTO.setDescription(eventsMaster.getDescription());
//        eventsMasterDTO.setLocation(eventsMaster.getLocation());
//        eventsMasterDTO.setPlannedHours(eventsMaster.getPlannedHours());
//        eventsMasterDTO.setCriteriaMasterList(eventsMaster.getCriteriaMasterList());
//        eventsMasterDTO.setEndDate(eventsMaster.getEndDate());
//        eventsMasterDTO.setScheduleLink(eventsMaster.getScheduleLink());
//        eventsMasterDTO.setType(eventsMaster.getType());
//        eventsMasterDTO.setJudgePanel(eventsMaster.getJudgePanel());
//        eventsMasterDTO.setTheme(eventsMaster.getTheme());
//        eventsMasterDTO.setStartDate(eventsMaster.getStartDate());
//        eventsMasterDTO.setOrganisingTeam(eventsMaster.getOrganisingTeam());
//        eventsMasterDTO.setProblemList(eventsMaster.getProblemList());
//        eventsMasterDTO.setTeamScoreCards(eventsMaster.getTeamScoreCards());
//        eventsMasterDTO.setTeamScoreSheets(eventsMaster.getTeamScoreSheets());
//        return eventsMasterDTO;
//    }
//}
