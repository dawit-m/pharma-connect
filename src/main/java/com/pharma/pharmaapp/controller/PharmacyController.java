package com.pharma.pharmaapp.controller;

import com.pharma.pharmaapp.entity.Pharmacy;
import com.pharma.pharmaapp.service.PharmacyService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pharmacy")
@CrossOrigin
public class PharmacyController {

    private final PharmacyService pharmacyService;

    public PharmacyController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    @PostMapping("/register")
    public Pharmacy register(@RequestBody Pharmacy pharmacy) {
        return pharmacyService.register(pharmacy);
    }
    @PostMapping("/login")
    public Pharmacy login(@RequestParam String username, @RequestParam String password) {
        return pharmacyService.login(username, password);
    }
    @GetMapping("/pharmacy/dashboard")
public String dashboard() {
    return "pharmacy-dashboard";
}
@PostMapping("/pharmacy/login")
public String pharmacyLogin(
        @RequestParam String username,
        @RequestParam String password,
        Model model
) {

    // TEMP logic (we'll improve later)
    if (username.equals("healthplus") && password.equals("1234")) {
        model.addAttribute("message", "Login successful");
        return "pharmacy-dashboard"; // next page
    }

    model.addAttribute("error", "Invalid username or password");
    return "pharmacy-login";
}

}
