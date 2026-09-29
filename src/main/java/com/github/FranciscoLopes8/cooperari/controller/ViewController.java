package com.github.FranciscoLopes8.cooperari.controller;

import com.github.FranciscoLopes8.cooperari.model.Folder;
import com.github.FranciscoLopes8.cooperari.model.User;
import com.github.FranciscoLopes8.cooperari.repository.FolderRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {


    @GetMapping("/")
    public String login(){
        return "login";
    }

    @GetMapping("/Dashboard")
    public String home(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");

        if (user == null) return "redirect:/";

        model.addAttribute("userName", user.getName());
        return "dashboard";
    }
}
