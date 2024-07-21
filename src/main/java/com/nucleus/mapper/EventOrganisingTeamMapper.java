//package com.nucleus.mapper;
//
//
//
//import com.nucleus.model.hmsmodels.EventOrganisingTeam;
//import com.nucleus.dto.EventOrganisingTeamDTO;
//
//public class EventOrganisingTeamMapper {
//
//    public EventOrganisingTeamDTO toDTO(EventOrganisingTeam entity) {
//        EventOrganisingTeamDTO dto = new EventOrganisingTeamDTO();
//        dto.setOrganisingTeamId(entity.getOrganisingTeamId());
//        dto.setEventId(entity.getEvent().getEventId());
//        dto.setRole(entity.getRole());
//        dto.setResponsibility(entity.getResponsibility());
//        return dto;
//    }
//
//    public EventOrganisingTeam toEntity(EventOrganisingTeamDTO dto) {
//        EventOrganisingTeam entity = new EventOrganisingTeam();
//        entity.setOrganisingTeamId(dto.getOrganisingTeamId());
//        entity.setResponsibility(dto.getResponsibility());
//        return entity;
//    }
//}
//
