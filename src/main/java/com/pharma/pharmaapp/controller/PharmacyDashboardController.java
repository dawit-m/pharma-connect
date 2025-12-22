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

    // Show dashboard
    @GetMapping("/dashboard")
    public String dashboard() {
        return "pharmacy-dashboard";
    }

    // Add medicine form submit
    @PostMapping("/add-medicine")
    public String addMedicine(
            @RequestParam String name,
            @RequestParam int quantity,
            Model model
    ) {
        Medicine medicine = new Medicine();
        medicine.setName(name);
        medicine.setQuantity(quantity);
        medicine.setPharmacy(null); // TEMP

        medicineService.save(medicine);
        model.addAttribute("message", "Medicine added successfully");

        return "pharmacy-dashboard";
    }
    @GetMapping("/medicines")
public String viewMedicines(Model model) {
    model.addAttribute(
        "medicines",
        medicineService.searchByName("Health Plus Pharmacy")
    );
    return "pharmacy-medicines";
}
@PostMapping("/delete-medicine")
public String deleteMedicine(@RequestParam Long id) {
    medicineService.deleteMedicine(id);
    return "redirect:/pharmacy/medicines";
}
}