package com.github.FranciscoLopes8.cooperari;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/Login")
    public String login(){
        return "login.html";
    }
}
