package com.nucleus.controller.organizer;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class OrganiserController {



    @GetMapping("/welcome")
    public String getDashboard(){
        return "dashboard/NotConfirmedUI/dashboard";
    }



}
