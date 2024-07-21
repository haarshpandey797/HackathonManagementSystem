//package com.nucleus.mapper;
//
//
//
//
//
//import com.nucleus.model.hmsmodels.OrganisersMaster;
//import com.nucleus.dto.OrganisersMasterDTO;
//
//public class OrganisersMasterMapper {
//
//    public OrganisersMasterDTO toDTO(OrganisersMaster entity) {
//        OrganisersMasterDTO dto = new OrganisersMasterDTO();
//        dto.setEmployeeId(entity.getEmployeeId());
//        dto.setName(entity.getName());
//        dto.setRole(entity.getRole());
//        dto.setContactNumber(entity.getContactNumber());
//        dto.setEmailId(entity.getEmailId());
//        dto.setDesignation(entity.getDesignation());
//        dto.setOrganisation(entity.getOrganisation());
//        dto.setBu(entity.getBu());
//        dto.setOrganisingTeamIds(entity.getOrganisingTeam());
//        return dto;
//    }
//
//    public OrganisersMaster toEntity(OrganisersMasterDTO dto) {
//        OrganisersMaster entity = new OrganisersMaster();
//        entity.setEmployeeId(dto.getEmployeeId());
//        entity.setName(dto.getName());
//        entity.setRole(dto.getRole());
//        entity.setContactNumber(dto.getContactNumber());
//        entity.setEmailId(dto.getEmailId());
//        entity.setDesignation(dto.getDesignation());
//        entity.setOrganisation(dto.getOrganisation());
//        entity.setBu(dto.getBu());
//        // Note: You may need to set organisingTeam using a service/repository method
//        return entity;
//    }
//}
//
//
//
