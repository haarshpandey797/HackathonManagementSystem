package com.nucleus.model.hmsmodels;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "EVENT_HMS")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "event_name", nullable = false)
    private String eventName;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "description")
    private String description;

    @Column(name = "type", nullable = false, columnDefinition = "varchar(255) default 'in-person'")
    private String eventType = "in-person";

    @Column(name = "theme")
    private String theme;

    @Column(name = "planned_hours")
    private Integer plannedHours;

    @Column(name = "schedule_link")
    private String scheduleLink;

    @Column(name = "approved_budget")
    private Integer approvedBudget;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "EVENT_PROBLEM_STATEMENT_MAPPING_HMS",
        joinColumns = @JoinColumn(name = "event_id", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "problem_statement_id", nullable = false)
    )
    private List<ProblemStatement> problemStatements = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "event" ,cascade = CascadeType.PERSIST)
    private List<EventOrganiserMapping> organiserMappings = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "event" ,cascade = CascadeType.MERGE)
    private List<JudgeEventMapping> judgeMappings = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "event",cascade = CascadeType.PERSIST)
    private List<Team> teamList;

    @ToString.Exclude
    @OneToMany(mappedBy = "event" ,cascade = CascadeType.PERSIST)
    private List<CriteriaEventMapping> criteriaEventMappings;

    @Column(name = "active_inactive_status")
    private Boolean activeInactiveStatus;

    @Column(name = "comments")
    private String comment;

    public Event(Long eventId) {
        this.eventId = eventId;
    }
}
