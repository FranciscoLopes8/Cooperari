package com.github.FranciscoLopes8.cooperari.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/Login")
    public String login(){
        return "/login.html";
    }

    @PostMapping("/Login")
    public String handleLogin(@RequestParam String email, @RequestParam String password){
        return "redirect:/Dashboard";
    }
}
