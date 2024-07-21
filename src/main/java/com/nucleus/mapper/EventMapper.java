package com.nucleus.mapper;

import com.nucleus.dto.EventDTO;
import com.nucleus.model.hmsmodels.Event;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {
    public Event dtoTOEvent(EventDTO eventDTO){
        Event event=new Event();

        event.setEventName(eventDTO.getEventName());
        event.setEventType(eventDTO.getEventType());
        event.setCriteriaEventMappings(eventDTO.getCriteriaEventMappings());
        event.setComment(eventDTO.getEventName());
        event.setDescription(eventDTO.getDescription());
        event.setEndDate(eventDTO.getEndDate());
        event.setActiveInactiveStatus(eventDTO.getActiveInactiveStatus());
        event.setLocation(eventDTO.getLocation());
        event.setApprovedBudget(eventDTO.getApprovedBudget());
//        event.setJudgeMappings(eventDTO.getJudgeMappings());
        event.setApprovedBudget(eventDTO.getApprovedBudget());
        event.setTheme(eventDTO.getTheme());
        event.setTeamList(eventDTO.getTeamList());
        event.setProblemStatements(eventDTO.getProblemStatements());
        event.setOrganiserMappings(eventDTO.getOrganiserMappings());
        event.setPlannedHours(eventDTO.getPlannedHours());
        return event;

    }
    public EventDTO eventToDTO(Event event){
        EventDTO eventDTO=new EventDTO();
        eventDTO.setEventName(event.getEventName());
        eventDTO.setEventType(event.getEventType());
        eventDTO.setCriteriaEventMappings(event.getCriteriaEventMappings());
        eventDTO.setComment(event.getEventName());
        eventDTO.setDescription(event.getDescription());
        eventDTO.setEndDate(event.getEndDate());
        eventDTO.setActiveInactiveStatus(event.getActiveInactiveStatus());
        eventDTO.setStartDate(event.getStartDate());
        eventDTO.setLocation(event.getLocation());
        eventDTO.setApprovedBudget(event.getApprovedBudget());
//        eventDTO.setJudgeMappings(event.getJudgeMappings());
        eventDTO.setApprovedBudget(event.getApprovedBudget());
        eventDTO.setTheme(event.getTheme());
        eventDTO.setTeamList(event.getTeamList());
        eventDTO.setProblemStatements(event.getProblemStatements());
        eventDTO.setOrganiserMappings(event.getOrganiserMappings());
        eventDTO.setPlannedHours(event.getPlannedHours());
        eventDTO.setEventId(event.getEventId());
        System.out.println(event.getProblemStatements());
        System.out.println(event.getCriteriaEventMappings());
        System.out.println(event.getJudgeMappings());
        System.out.println(event.getOrganiserMappings());
        System.out.println(event.getTeamList());
        return eventDTO;

    }
}
