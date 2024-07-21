package com.nucleus.model.extra;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class JudgeEventMappingId implements Serializable {

    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "judge_id")
    private Long judgeId;

    public JudgeEventMappingId() {
    }

    public JudgeEventMappingId(Long eventId, Long judgeId) {
        this.eventId = eventId;
        this.judgeId = judgeId;
    }
}
