package com.nucleus.controller.judge;

import com.nucleus.dto.*;
import com.nucleus.dto.EventDTO;
import com.nucleus.service.evaluation.EvaluationService;
import com.nucleus.service.judge.JudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Transactional
@Controller
@RequestMapping("/judge")
public class JudgeController {
    @Autowired
    JudgeService judgeService;
    @Autowired
    EventDTO eventDTO;
    @Autowired
    JudgeDTO judgeDTO;
    @Autowired
    EvaluationService evaluationService;


    @RequestMapping(path="/welcome")
    public String judgeDashBoard(Model model){
        eventDTO=judgeService.getEvents();
        model.addAttribute("hackathon",eventDTO);
        return "dashboard/judgeDashBoard";
    }
    @RequestMapping(path="/events")
    public String viewEvents(Model model){
       eventDTO=judgeService.getEvents();
       model.addAttribute("event",eventDTO);

        return "dashboard/viewEvents";
    }
    @RequestMapping(path="/viewTeam")
    public String showTeams(Model model){
        long eventId=judgeService.getEvents().getEventId();
        List<TeamDto> teams=evaluationService.showTeams(eventId);
        model.addAttribute("teams",teams);
        return "dashboard/evaluation/viewTeam";
    }
  @RequestMapping(path="/viewProblem")
    public String showProblem(Model model){
      long eventId=judgeService.getEvents().getEventId();
      List<ProblemStatementDTO> problems=judgeService.showProblems(eventId);
      model.addAttribute("problems",problems);
        return "dashboard/evaluation/viewProblem";
  }
}
