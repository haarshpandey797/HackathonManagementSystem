package com.nucleus.controller.participants;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="admin")
public class ParticipantsController {

    @RequestMapping(path = "/createParticipants")
    public String createParticipants(Model model) {
        return "dashboard/participant/createParticipant";
    }

    @RequestMapping(path = "/uploadParticipants")
    public String uploadParticipants(Model model) {
        return "dashboard/participant/uploadParticipant";
    }

    @RequestMapping(path = "/viewAllParticipants")
    public String viewAllParticipants(Model model) {
        return "dashboard/participant/viewAllParticipant";
    }
}
