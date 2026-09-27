package com.github.FranciscoLopes8.cooperari.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String login(){
        return "/login.html";
    }
    @GetMapping("/Dashboard")
    public String home(){
        return "/dashboard.html";
    }
}
