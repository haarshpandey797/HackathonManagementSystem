//package com.nucleus.dto;
//
//import com.nucleus.model.hmsmodels.*;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.util.List;
//
//
//    @Component
//    public class EventsMasterDTO {
//
//        private Long eventId;
//
//        private String eventName;
//
//        private LocalDate startDate;
//
//        private LocalDate endDate;
//
//        private String location;
//
//        private String description;
//
//        private String type = "in-person";
//
//        private String theme;
//
//        private Integer plannedHours;
//
//        private String scheduleLink;
//
//        private Integer approvedBudget;
//
//        private List<ProblemStatementMaster> problemList;
//
//
//        private EventOrganisingTeam organisingTeam;
//
//
//        private List<ParticipatingTeams> teamList;
//
//
//        private List<CriteriaMaster> criteriaMasterList;
//
//
//        private List<TeamScoreSheet> teamScoreSheets;
//
//
//        private List<TeamScoreCard> teamScoreCards;
//
//
//        JudgePanel judgePanel;
//
//        // Constructors
//
//        public EventsMasterDTO() {
//        }
//
//        public EventsMasterDTO(Long eventId, String eventName, LocalDate startDate, LocalDate endDate, String location, String description, String type, String theme, Integer plannedHours, String scheduleLink, Integer approvedBudget, List<ProblemStatementMaster> problemList, EventOrganisingTeam organisingTeam, List<ParticipatingTeams> teamList, List<CriteriaMaster> criteriaMasterList, List<TeamScoreSheet> teamScoreSheets, List<TeamScoreCard> teamScoreCards, JudgePanel judgePanel) {
//            this.eventId = eventId;
//            this.eventName = eventName;
//            this.startDate = startDate;
//            this.endDate = endDate;
//            this.location = location;
//            this.description = description;
//            this.type = type;
//            this.theme = theme;
//            this.plannedHours = plannedHours;
//            this.scheduleLink = scheduleLink;
//            this.approvedBudget = approvedBudget;
//            this.problemList = problemList;
//            this.organisingTeam = organisingTeam;
//            this.teamList = teamList;
//            this.criteriaMasterList = criteriaMasterList;
//            this.teamScoreSheets = teamScoreSheets;
//            this.teamScoreCards = teamScoreCards;
//            this.judgePanel = judgePanel;
//        }
//
//        // Getters and Setters
//
//
//        @Override
//        public String toString() {
//            return "EventsMasterDTO{" +
//                    "eventId=" + eventId +
//                    ", eventName='" + eventName + '\'' +
//                    ", startDate=" + startDate +
//                    ", endDate=" + endDate +
//                    ", location='" + location + '\'' +
//                    ", description='" + description + '\'' +
//                    ", type='" + type + '\'' +
//                    ", theme='" + theme + '\'' +
//                    ", plannedHours=" + plannedHours +
//                    ", scheduleLink='" + scheduleLink + '\'' +
//                    ", approvedBudget=" + approvedBudget +
//                    ", problemList=" + problemList +
//                    ", organisingTeam=" + organisingTeam +
//                    ", teamList=" + teamList +
//                    ", criteriaMasterList=" + criteriaMasterList +
//                    ", teamScoreSheets=" + teamScoreSheets +
//                    ", teamScoreCards=" + teamScoreCards +
//                    ", judgePanel=" + judgePanel +
//                    '}';
//        }
//
//        public Long getEventId() {
//            return eventId;
//        }
//
//        public void setEventId(Long eventId) {
//            this.eventId = eventId;
//        }
//
//        public String getEventName() {
//            return eventName;
//        }
//
//        public void setEventName(String eventName) {
//            this.eventName = eventName;
//        }
//
//        public LocalDate getStartDate() {
//            return startDate;
//        }
//
//        public void setStartDate(LocalDate startDate) {
//            this.startDate = startDate;
//        }
//
//        public LocalDate getEndDate() {
//            return endDate;
//        }
//
//        public void setEndDate(LocalDate endDate) {
//            this.endDate = endDate;
//        }
//
//        public String getLocation() {
//            return location;
//        }
//
//        public void setLocation(String location) {
//            this.location = location;
//        }
//
//        public String getDescription() {
//            return description;
//        }
//
//        public void setDescription(String description) {
//            this.description = description;
//        }
//
//        public String getType() {
//            return type;
//        }
//
//        public void setType(String type) {
//            this.type = type;
//        }
//
//        public String getTheme() {
//            return theme;
//        }
//
//        public void setTheme(String theme) {
//            this.theme = theme;
//        }
//
//        public Integer getPlannedHours() {
//            return plannedHours;
//        }
//
//        public void setPlannedHours(Integer plannedHours) {
//            this.plannedHours = plannedHours;
//        }
//
//        public String getScheduleLink() {
//            return scheduleLink;
//        }
//
//        public void setScheduleLink(String scheduleLink) {
//            this.scheduleLink = scheduleLink;
//        }
//
//        public Integer getApprovedBudget() {
//            return approvedBudget;
//        }
//
//        public void setApprovedBudget(Integer approvedBudget) {
//            this.approvedBudget = approvedBudget;
//        }
//
//        public List<ProblemStatementMaster> getProblemList() {
//            return problemList;
//        }
//
//        public void setProblemList(List<ProblemStatementMaster> problemList) {
//            this.problemList = problemList;
//        }
//
//        public EventOrganisingTeam getOrganisingTeam() {
//            return organisingTeam;
//        }
//
//        public void setOrganisingTeam(EventOrganisingTeam organisingTeam) {
//            this.organisingTeam = organisingTeam;
//        }
//
//        public List<ParticipatingTeams> getTeamList() {
//            return teamList;
//        }
//
//        public void setTeamList(List<ParticipatingTeams> teamList) {
//            this.teamList = teamList;
//        }
//
//        public List<CriteriaMaster> getCriteriaMasterList() {
//            return criteriaMasterList;
//        }
//
//        public void setCriteriaMasterList(List<CriteriaMaster> criteriaMasterList) {
//            this.criteriaMasterList = criteriaMasterList;
//        }
//
//        public List<TeamScoreSheet> getTeamScoreSheets() {
//            return teamScoreSheets;
//        }
//
//        public void setTeamScoreSheets(List<TeamScoreSheet> teamScoreSheets) {
//            this.teamScoreSheets = teamScoreSheets;
//        }
//
//        public List<TeamScoreCard> getTeamScoreCards() {
//            return teamScoreCards;
//        }
//
//        public void setTeamScoreCards(List<TeamScoreCard> teamScoreCards) {
//            this.teamScoreCards = teamScoreCards;
//        }
//
//        public JudgePanel getJudgePanel() {
//            return judgePanel;
//        }
//
//        public void setJudgePanel(JudgePanel judgePanel) {
//            this.judgePanel = judgePanel;
//        }
//    }
//
//
