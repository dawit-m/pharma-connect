package com.pharma.pharmaapp.controller;

import com.pharma.pharmaapp.entity.Medicine;
import com.pharma.pharmaapp.service.MedicineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pharmacy")
public class PharmacyDashboardController {

    private final MedicineService medicineService;

    public PharmacyDashboardController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    // --- ADDED: HOME PAGE (Fixes the white page at start) ---
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // --- ADDED: HANDLE LOGIN BUTTON ---
    @PostMapping("/login")
    public String handleLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ) {
        if ("healthplus".equals(username) && "1234".equals(password)) {
            return "pharmacy-dashboard";
        }
        model.addAttribute("error", "Invalid username or password");
        return "pharmacy-login";
    }

    // --- EXISTING DASHBOARD CODE ---
    @GetMapping("/dashboard")
    public String dashboard() {
        return "pharmacy-dashboard";
    }

    @PostMapping("/add-medicine")
    public String addMedicine(
            @RequestParam String name,
            @RequestParam int quantity,
            Model model
    ) {
        Medicine medicine = new Medicine();
        medicine.setName(name);
        medicine.setQuantity(quantity);
        medicine.setPharmacy(null); 

        medicineService.save(medicine);
        model.addAttribute("message", "Medicine added successfully");
        return "pharmacy-dashboard";
    }

    @GetMapping("/medicines")
    public String viewMedicines(Model model) {
        model.addAttribute("medicines", medicineService.searchByName(""));
        return "pharmacy-medicines";
    }

    @PostMapping("/delete-medicine")
    public String deleteMedicine(@RequestParam Long id) {
        medicineService.deleteMedicine(id);
        return "redirect:/pharmacy/medicines";
    }
}