package com.nucleus.controller.evaluation;

import com.nucleus.dto.CriteriaDTO;
import com.nucleus.dto.CriteriaEventMappingDTO;
import com.nucleus.dto.TeamDto;
import com.nucleus.service.criteriaEventMappingService.CriteriaEventMappingService;
import com.nucleus.service.evaluation.EvaluationService;
import com.nucleus.service.judge.JudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Transactional
@RequestMapping("/judge")
@Controller
public class EvaluationController {
    @Autowired
    EvaluationService evaluationService;
    @Autowired
    JudgeService judgeService;

    @Autowired
    CriteriaEventMappingService eventMappingService;




    @RequestMapping(path="/showGrid")
    @Transactional
    public String showGrid(Model model){
        long eventId=judgeService.getEvents().getEventId();

        List<CriteriaDTO> criterias=evaluationService.showCriterias(eventId);
        List<TeamDto> teams=evaluationService.showTeams(eventId);
        model.addAttribute("criteriaList",criterias);
        model.addAttribute("teams",teams);
        return "dashboard/evaluation/evaluation";
    }

    @PostMapping("/submitEvaluation")
    @Transactional
    public String submitEvaluation(@RequestParam Map<String, String> scores,  Model model) {
        long eventId=judgeService.getEvents().getEventId();
        System.out.println(eventId);

        // Fetch all criteria and their weights
        List<CriteriaEventMappingDTO> allCriteriaForAEvent = eventMappingService.getAllCriteriaForAEvent(eventId);
        System.out.println(" Hello Friend +    " + allCriteriaForAEvent);
        Map<String, Integer> criteriaWeights = allCriteriaForAEvent.stream()
                .collect(Collectors.toMap(crit -> crit.getCriteria().getCriteriaName(), CriteriaEventMappingDTO::getWeightage));
        System.out.println("weight is " +criteriaWeights);

        Map<String, Map<String, Integer>> teamScores = new HashMap<>();
        Map<String, Integer> teamTotalScores = new HashMap<>();
        List<List<String>> finalScoreList = new ArrayList<>();
        for (Map.Entry<String, String> entry : scores.entrySet()) {
            List<String> newList = new ArrayList<>();
            String[] parts = entry.getKey().split("\\]\\[");
            String teamName = parts[0].substring(7); // Remove "scores[" prefix and "]" suffix
            newList.add(teamName);
            String category = parts[1].substring(0, parts[1].length() - 1); // Remove "]" suffix
            newList.add(category);
            int score = Integer.parseInt(entry.getValue());

            newList.add(String.valueOf(score));
            // Get the weight of the current category
            int weight = criteriaWeights.getOrDefault(category, 100);

            // Calculate the weighted score
            int weightedScore = (score * weight);



            // Initialize team score map if not exists
            teamScores.computeIfAbsent(teamName, k -> new HashMap<>());
            teamScores.get(teamName).put(category, weightedScore);


            // Calculate total score for each team
            int totalScore = teamTotalScores.getOrDefault(teamName, 0) + weightedScore;
            teamTotalScores.put(teamName, totalScore);

            finalScoreList.add(newList);

        }

        System.out.println("Final Team Scores : "+ teamScores );
        System.out.println("Total Team Scores : "+ teamTotalScores );
        System.out.println("Final List" + finalScoreList);
        //logger.info("The Final List is :" +finalScoreList);


        evaluationService.processAndStoreResults(finalScoreList);


        // Add scores and totals to model attributes
        model.addAttribute("teamScores", teamScores);
        model.addAttribute("teamTotalScores", teamTotalScores);

        return "dashboard/evaluation/viewScore";
    }


}
