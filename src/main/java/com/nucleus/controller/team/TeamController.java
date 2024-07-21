package com.nucleus.controller.team;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="admin")
public class TeamController {

    @RequestMapping(path="/createTeam")
    public String createTeam(Model model){
        return "dashboard/team/createTeam";
    }
    @RequestMapping(path="/uploadTeam")
    public String uploadTeam(Model model){
        return "dashboard/team/uploadTeam";
    }
    @RequestMapping(path="/viewAllTeam")
    public String viewAllTeam(Model model){
        return "dashboard/team/viewAllTeam";
    }
}
