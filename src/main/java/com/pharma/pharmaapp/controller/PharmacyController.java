package com.pharma.pharmaapp.controller;

import com.pharma.pharmaapp.entity.Pharmacy;
import com.pharma.pharmaapp.service.PharmacyService;
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
    public Pharmacy login(
            @RequestParam String username,
            @RequestParam String password
    ) {
        return pharmacyService.login(username, password);
    }
    @PostMapping("/pharmacy/add-medicine")
public String addMedicine(
        @RequestParam String name,
        @RequestParam double price,
        @RequestParam int quantity
) {
    pharmacyService.addMedicine(name, price, quantity);
    return "redirect:/pharmacy/dashboard";
}

}
