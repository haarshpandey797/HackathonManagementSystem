package com.nucleus.dto;

import com.nucleus.model.hmsmodels.JudgeEventMapping;
import com.nucleus.utility.enums.BusinessUnit;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.List;

@Data
@Component
public class JudgeDTO {
    private Long judgeId;
    private String judgeName;
    private BusinessUnit judgeBU;
    private Long judgeContactNo;
    private String judgeEmail;
    private String judgeDesignation;
    private Long judgeEmployeeId;
}
