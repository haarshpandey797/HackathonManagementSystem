package com.nucleus.model.hmsmodels;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "ORGANISER_HMS")
public class Organiser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "organiser_id")
    private Long organiserId;

    @Column(name = "organiser_employee_id", unique = true)
    private Long organiserEmployeeId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "designation")
    private String designation;

    @Column(name = "organisation")
    private String organisation;

    @Column(name = "business_unit")
    private String businessUnit;

    @ToString.Exclude
    @OneToMany(mappedBy = "organiser")
    private List<EventOrganiserMapping> organiserMappings = new ArrayList<>();

}
