package com.nucleus.controller.problemstatement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="admin")
public class ProblemStatementController {

    @RequestMapping(path = "/createProblemStatement")
    public String createroblemStatement(Model model) {
        return "dashboard/problemStatement/createNewProblem";
    }

    @RequestMapping(path = "/uploadProblemStatement")
    public String uploadroblemStatement(Model model) {
        return "dashboard/problemStatement/uploadProblem";
    }

    @RequestMapping(path = "/viewAllProblemStatement")
    public String viewAllroblemStatement(Model model) {

        return "dashboard/problemStatement/viewAllProblem";
    }
}
