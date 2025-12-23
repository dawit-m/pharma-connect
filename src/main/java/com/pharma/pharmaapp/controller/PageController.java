package com.pharma.pharmaapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/client")
    public String clientPage() {
        return "client";
    }

    @GetMapping("/pharmacy/login")
    public String pharmacyLoginPage() {
        return "pharmacy-login";
    }
}
