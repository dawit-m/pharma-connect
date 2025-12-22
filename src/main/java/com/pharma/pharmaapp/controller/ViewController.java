package com.pharma.pharmaapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ViewController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/pharmacy/login")
    public String showLoginPage() {
        return "pharmacy-login";
    }

    @PostMapping("/pharmacy/login")
    public String handleLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ) {
        // TEMP logic
        if ("healthplus".equals(username) && "1234".equals(password)) {
            return "pharmacy-dashboard";
        }

        model.addAttribute("error", "Invalid username or password");
        return "pharmacy-login";
    }
    @GetMapping("/pharmacy/dashboard")
    public String dashboard(){
        return "pharmacy-dashboard";
    }
}
