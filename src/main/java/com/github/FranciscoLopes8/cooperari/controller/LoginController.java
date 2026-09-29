package com.github.FranciscoLopes8.cooperari.controller;

import com.github.FranciscoLopes8.cooperari.model.User;
import com.github.FranciscoLopes8.cooperari.repository.UserRepository;
import com.github.FranciscoLopes8.cooperari.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/Login")
    public String handleLogin(@RequestParam String email, @RequestParam String password, HttpSession session){
        boolean valid = userService.ValidateCredentials(email, password, session);
        if (valid)  {
            return "redirect:/Dashboard";
        }
        else return "redirect:/Login";
    }

    @PostMapping("/Signup")
    public String handleSignup(@RequestParam String name, @RequestParam String email, @RequestParam String password, HttpSession session){
        boolean valid = userService.CreateAccount(name, email, password, session);

        if (valid) return "redirect:/Dashboard";
        else return "redirect:/Login";
    }
}
