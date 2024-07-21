package com.nucleus.model.hmsmodels;

import lombok.Data;
import lombok.ToString;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "CRITERIA_HMS")
public class Criteria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "criteria_id")
    private Long criteriaId;

    @Column(name = "criteria_name",unique = true)
    private String criteriaName;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "category")
    private String category;

    @ToString.Exclude
    @OneToMany(mappedBy = "criteria")
    private List<CriteriaEventMapping> criteriaEventMappings;
}
