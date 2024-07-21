package com.nucleus.controller.judge;

import com.nucleus.dto.JudgeDTO;
import com.nucleus.service.judge.JudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("admin")
public class JudgeControllerByOrganiser {

    @Autowired
    JudgeService service;

    @RequestMapping(path = "/createJudge")
    public String createJudge(Model model) {
        JudgeDTO judge = new JudgeDTO();
        model.addAttribute("judge", judge);
        return "dashboard/judge/createJudge";
    }
    @PostMapping("/saveJudge")
    public String saveJudge(@ModelAttribute("judge") JudgeDTO judge) {
        service.saveJudge(judge);  //Saving the judge Data
        return "dashboard/judge/viewAllJudge";
    }

    @RequestMapping(path = "/uploadJudge")
    public String uploadJudge(Model model) {
        return "dashboard/judge/uploadJudge";
    }

    @RequestMapping(path = "/viewAllJudge")
    public String viewAllJudge(Model model) {
        List<JudgeDTO> allJudges = service.getAllJudges();
        model.addAttribute("allJudges", allJudges);
        return "dashboard/judge/viewAllJudge";
    }


}
