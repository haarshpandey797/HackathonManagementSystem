package com.nucleus.model.hmsmodels;

import com.nucleus.utility.enums.BusinessUnit;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name="JUDGE_HMS")
public class Judge {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="judge_id")
    private Long judgeId;

    @Column(name="judge_name")
    private String judgeName;

    @Column(name="judge_bu")
    private BusinessUnit judgeBU;

    @Column(name="judge_contact_no")
    private Long judgeContactNo;

    @Column(name="judge_email")
    private String judgeEmail;

    @Column(name="judge_designation")
    private String judgeDesignation;

    @Column(name = "judge_employee_id", unique = true)
    private Long judgeEmployeeId;

    @ToString.Exclude
    @OneToMany(mappedBy = "judge")
    private List<JudgeEventMapping> judgeEventMappings = new ArrayList<>();

    public Judge(Long judgeId) {
        this.judgeId = judgeId;
    }
}
