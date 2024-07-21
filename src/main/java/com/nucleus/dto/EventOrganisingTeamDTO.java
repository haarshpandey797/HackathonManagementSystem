package com.nucleus.dto;


import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class EventOrganisingTeamDTO {
        private Long organisingTeamId;
        private Long eventId; // Assuming you want to reference the EventsMaster ID
        private List<Long> organisersIds; // Assuming you want to reference the OrganisersMaster IDs
        private String role;
        private String responsibility;

        // Constructors

        public EventOrganisingTeamDTO() {
        }

        public EventOrganisingTeamDTO(Long organisingTeamId, Long eventId, List<Long> organisersIds, String role, String responsibility) {
            this.organisingTeamId = organisingTeamId;
            this.eventId = eventId;
            this.organisersIds = organisersIds;
            this.role = role;
            this.responsibility = responsibility;
        }

        // Getters and Setters

        public Long getOrganisingTeamId() {
            return organisingTeamId;
        }

        public void setOrganisingTeamId(Long organisingTeamId) {
            this.organisingTeamId = organisingTeamId;
        }

        public Long getEventId() {
            return eventId;
        }

        public void setEventId(Long eventId) {
            this.eventId = eventId;
        }

        public List<Long> getOrganisersIds() {
            return organisersIds;
        }

        public void setOrganisersIds(List<Long> organisersIds) {
            this.organisersIds = organisersIds;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getResponsibility() {
            return responsibility;
        }

        public void setResponsibility(String responsibility) {
            this.responsibility = responsibility;
        }
    }


