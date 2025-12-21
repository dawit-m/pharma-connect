package com.pharma.pharmaapp.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/client")
    public String clientPage() {
        return "client";
    }

    @GetMapping("/pharmacy/login")
    public String pharmacyLogin() {
        return "pharmacy-login";
    }
}
