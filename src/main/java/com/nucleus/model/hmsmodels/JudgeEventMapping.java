package com.nucleus.model.hmsmodels;

import com.nucleus.model.extra.JudgeEventMappingId;
import com.nucleus.utility.enums.JudgeRole;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="JUDGE_EVENT_MAPPING_HMS")
public class JudgeEventMapping {

    @EmbeddedId
    private JudgeEventMappingId id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="judge_id")
    @MapsId("judgeId")
    private Judge judge;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="event_id")
    @MapsId("eventId")
    private Event event;

    @Column(name = "role")
    private JudgeRole role;

    @Column(name = "responsibility")
    private String responsibility;

}
