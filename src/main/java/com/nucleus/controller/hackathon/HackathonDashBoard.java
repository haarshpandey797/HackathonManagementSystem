package com.nucleus.controller.hackathon;

import com.nucleus.dto.*;

import com.nucleus.model.hmsmodels.Event;
import com.nucleus.service.hackathon.HackathonService;
import com.nucleus.service.judge.JudgeService;
import com.nucleus.service.problemstatementservice.ProblemStatementService;
import com.nucleus.service.team.TeamService;
import com.nucleus.utility.DateEditor;
import com.nucleus.utility.enums.JudgeRole;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Transactional
@Controller
@RequestMapping(path="admin")
public class HackathonDashBoard {
   @Autowired
   HackathonService hackathonService;
   @Autowired
   JudgeService judgeService;

   @Autowired
   ProblemStatementService problemStatementService;
   @Autowired
    TeamService teamService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {//To convert String to date
        binder.registerCustomEditor(LocalDate.class, "startDate", new DateEditor());
        binder.registerCustomEditor(LocalDate.class, "endDate", new DateEditor());
    }
    @RequestMapping("/runningHackathons")
    public String getCurrentHackathons(Model model) {
        List<Event> eventsMasterList = hackathonService.getEvent(); // Assuming this method correctly fetches events
        if (!eventsMasterList.isEmpty()) {
            model.addAttribute("hackathon", eventsMasterList.get(0)); // Add first event to the model
        } else {
            Event hackathon = new Event();
            hackathon.setEventName("No Hackathon");
            hackathon.setDescription("There is no hackathon present. Please create one.");
            model.addAttribute("hackathon", hackathon);
        }
        return "dashboard/hackathon/runningHackathon"; // return the JSP page name
    }

    @RequestMapping(path="/pastHackathons")
    public String getpastHackaThons(Model model){
        List<Event> eventsMasterList = hackathonService.getAllEvent();
        model.addAttribute("runningHackathons", eventsMasterList);
        return "dashboard/hackathon/pastHackathon";
    }

    @RequestMapping(path="/createHackathons")
    public String createHackathons( Model model){
        model.addAttribute("event",new Event());
        return "dashboard/hackathon/createNewHackathon";
    }
    @PostMapping("/handleForm")
    public String handleForm(@ModelAttribute Event event ){
        hackathonService.saveEvent(event);
        return "dashboard/hackathon/runningHackathon";
    }


    @RequestMapping("/addDataToEvent")
    public String addMoreData(){
        return "dashboard/hackathon/addMoreInfo";
    }

    @RequestMapping("/addJudgeToEvent")
    public String addJudgesToEvent(Model model){
        List<JudgeDTO> judgesDtoList = judgeService.getAllJudges();

        List<JudgeRole> judgeRoles= Arrays.asList(JudgeRole.values());

        model.addAttribute("roles", judgeRoles);
        model.addAttribute("judges", judgesDtoList);

        return "dashboard/hackathon/addFromJudgesList";
    }

    @RequestMapping("/processJudges")
    @ResponseBody
    public String processJudges(HttpServletRequest request, @RequestParam(value = "selectedJudges", required = false) List<Long> selectedJudgeIds) {
//        if (selectedJudgeIds != null && !selectedJudgeIds.isEmpty()) {
//            boolean added = hackathonService.addJudgeListToEvent(selectedJudgeIds);
//            if(added)return "Success";
//            else return "Failure";
//        }
        List<JudgeEventMappingDTO> judgeEventMappingDTOList = new ArrayList<>();
        // Process each selected judge with their role and responsibility
        if (selectedJudgeIds != null && !selectedJudgeIds.isEmpty()) {
            for (long judgeId : selectedJudgeIds) {
                String role = request.getParameter("roles_" + judgeId);
                String responsibility = request.getParameter("responsibility_" + judgeId);

                // Assuming you have a method to update judge details
                JudgeEventMappingDTO judgeEventMappingDTO = new JudgeEventMappingDTO();
                judgeEventMappingDTO.setJudgeId(judgeId);
                judgeEventMappingDTO.setRole(JudgeRole.valueOf(role));
                judgeEventMappingDTO.setResponsibility(responsibility);
                judgeEventMappingDTOList.add(judgeEventMappingDTO);
            }
            boolean added = hackathonService.addJudgeListToEvent(judgeEventMappingDTOList);
            if(added)
                return "True";
            return "False";
        }
        else {
            return "Failure";
        }
    }

    @RequestMapping("/addProblemStatementsToEvent")
    public String addProblemStatementsToEvent(Model model){
        List<ProblemStatementDTO> problemStatementDTOS = problemStatementService.getAllProblems();

        model.addAttribute("problems", problemStatementDTOS);

        return "dashboard/hackathon/addFromProblemStatementList";
    }

    @RequestMapping("/processProblems")
    @ResponseBody
    public String processProblems(@RequestParam(value = "selectedProblems", required = false) List<Long> selectedProblemIds) {
        if (selectedProblemIds != null && !selectedProblemIds.isEmpty()) {
            boolean added = hackathonService.addProblemListToEvent(selectedProblemIds);
            System.out.println(selectedProblemIds);
            if(added)return "Success";
            else return "Failure";
      }
        else {
            return "Failure";
        }
    }

    @RequestMapping("/addTeamsToEvent")
    public String addTeamsToEvent(Model model){
        List<TeamDto> teamDtos = teamService.getAllTeams();

        model.addAttribute("teams", teamDtos);

        return "dashboard/hackathon/addFromTeamList";
    }

    @RequestMapping(path="/viewAllDetails/{eventId}")
    public String getAllDetails(@PathVariable Long eventId, Model model){
        EventDTO eventDTO = hackathonService.getEventById(eventId);
        System.out.println("This is the final event" +eventDTO);
        model.addAttribute("event" , eventDTO);
        return "dashboard/hackathon/viewAllDetails";
    }

    @RequestMapping("/processTeams")
    @ResponseBody
    public String processTeams(@RequestParam(value = "selectedTeams", required = false) List<Long> selectedTeamIds) {
        if (selectedTeamIds != null && !selectedTeamIds.isEmpty()) {
            boolean added = hackathonService.addTeamListToEvent(selectedTeamIds);
            System.out.println(selectedTeamIds);
            if(added)return "Success";
            else return "Failure";
        }
        else {
            return "Failure";
        }
    }
}
