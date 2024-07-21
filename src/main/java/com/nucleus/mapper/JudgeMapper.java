//package com.nucleus.mapper;
//
//import com.nucleus.dto.JudgeDTO;
//import com.nucleus.model.hmsmodels.Judge;
//import org.springframework.stereotype.Component;
//
//@Component
//public class JudgeMapper {
//    public Judge toEntity(JudgeDTO judgeDTO) {
//        Judge judge = new Judge();
//        judge.setJudgeId(judgeDTO.getJudgeId());
//        judge.setJudgeName(judgeDTO.getJudgeName());
//        judge.setJudgeBU(judgeDTO.getJudgeBU());
//        judge.setJudgeContactNo(judgeDTO.getJudgeContactNo());
//        judge.setJudgeEmail(judgeDTO.getJudgeEmail());
//        judge.setJudgeDesignation(judgeDTO.getJudgeDesignation());
//        judge.setJudgeEmployeeId(judgeDTO.getJudgeEmployeeId());
//        return judge;
//    }
//
//    public JudgeDTO judgeToDTO(Judge judge) {
//        JudgeDTO judgeDTO = new JudgeDTO();
//        judgeDTO.setJudgeBU(judge.getJudgeBU());
//        judgeDTO.setJudgeDesignation(judge.getJudgeDesignation());
//        judgeDTO.setJudgeEmail(judge.getJudgeEmail());
//        judgeDTO.setJudgeContactNo(judgeDTO.getJudgeContactNo());
//        judgeDTO.setJudgeName(judge.getJudgeName());
//        judgeDTO.setJudgeEmployeeId(judge.getJudgeEmployeeId());
//
//        return judgeDTO;
//    }
//}
