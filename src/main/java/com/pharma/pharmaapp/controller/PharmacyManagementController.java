package com.pharma.pharmaapp.controller;

import com.pharma.pharmaapp.entity.Medicine;
import com.pharma.pharmaapp.service.MedicineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pharmacy")
public class PharmacyManagementController {

    private final MedicineService medicineService;

    public PharmacyManagementController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    // 1. Show the Login Page
    @GetMapping("/login")
    public String showLoginPage() {
        return "pharmacy-login";
    }

    // 2. Handle Login Logic
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // Simple hardcoded check for now
        if ("healthplus".equals(username) && "1234".equals(password)) {
            return "redirect:/pharmacy/dashboard";
        }
        model.addAttribute("error", true);
        return "pharmacy-login";
    }

    // 3. Show the Dashboard with the List of Medicines
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Medicine> medicines = medicineService.findAll();
        model.addAttribute("medicines", medicines);
        return "pharmacy-dashboard";
    }

    // 4. Handle Adding New Medicine
    @PostMapping("/add-medicine")
    public String addMedicine(@RequestParam String name,
            @RequestParam double price,
            @RequestParam int quantity) {
        Medicine medicine = new Medicine();
        medicine.setName(name);
        medicine.setPrice(price);
        medicine.setQuantity(quantity);
        medicine.setSearchCount(0); // Initialize search count to zero

        medicineService.save(medicine);
        return "redirect:/pharmacy/dashboard";
    }

    // 5. Handle Deleting Medicine
    @GetMapping("/delete-medicine/{id}")
    public String deleteMedicine(@PathVariable Long id) {
        medicineService.deleteMedicine(id);
        return "redirect:/pharmacy/dashboard";
    }
}