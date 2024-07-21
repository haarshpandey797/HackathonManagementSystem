package com.nucleus.controller.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Developer :  Anushka
@Controller
public class LoginController {
    //Displaying login page
    @GetMapping("/login")
    public String login() {
        return "dashboard/loginPage";
    }

    //Redirecting to log out
    @GetMapping("/logout")
    public String logout() {
        return "redirect:http://localhost:8080/FinalProject/login?logout";
    }
}