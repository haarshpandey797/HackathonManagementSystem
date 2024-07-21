package com.nucleus.dto;

import com.nucleus.utility.enums.JudgeRole;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class JudgeEventMappingDTO {

    private Long judgeId;

    private Long eventId;

    private JudgeRole role;

    private String responsibility;

}
