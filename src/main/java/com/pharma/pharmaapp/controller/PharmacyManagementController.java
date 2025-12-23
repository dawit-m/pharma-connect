package com.pharma.pharmaapp.controller;

import com.pharma.pharmaapp.entity.Medicine;
import com.pharma.pharmaapp.entity.Pharmacy;
import com.pharma.pharmaapp.repository.PharmacyRepository;
import com.pharma.pharmaapp.service.MedicineService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pharmacy")
public class PharmacyManagementController {

    @Autowired
    private MedicineService medicineService;

    @Autowired
    private PharmacyRepository pharmacyRepository;

    // --- 1. REGISTRATION ---

    @GetMapping("/register")
    public String showRegisterPage() {
        return "pharmacy-register";
    }

    @PostMapping("/register")
    public String registerPharmacy(@RequestParam String pharmacyName,
            @RequestParam String location,
            @RequestParam String tinNumber,
            @RequestParam String username,
            @RequestParam String password) {
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setPharmacyName(pharmacyName);
        pharmacy.setLocation(location);
        pharmacy.setTinNumber(tinNumber);
        pharmacy.setUsername(username);
        pharmacy.setPassword(password);

        pharmacyRepository.save(pharmacy);
        // Redirect to login with a success message parameter
        return "redirect:/pharmacy/login?registered=true";
    }

    // --- 2. LOGIN ---

    @GetMapping("/login")
    public String showLoginPage() {
        return "pharmacy-login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
            @RequestParam String password,
            HttpSession session,
            Model model) {

        Optional<Pharmacy> pharmacyOpt = pharmacyRepository.findByUsername(username);

        if (pharmacyOpt.isPresent() && pharmacyOpt.get().getPassword().equals(password)) {
            // Store the whole Pharmacy object in the session
            session.setAttribute("loggedInPharmacy", pharmacyOpt.get());
            return "redirect:/pharmacy/dashboard";
        }

        model.addAttribute("error", true);
        return "pharmacy-login";
    }

    // --- 3. DASHBOARD ---

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        Pharmacy loggedInPharmacy = (Pharmacy) session.getAttribute("loggedInPharmacy");

        // Security check: If not logged in, send back to login page
        if (loggedInPharmacy == null) {
            return "redirect:/pharmacy/login";
        }

        // Only show medicines belonging to THIS pharmacy
        List<Medicine> medicines = medicineService.findByPharmacy(loggedInPharmacy);
        model.addAttribute("medicines", medicines);
        model.addAttribute("pharmacyName", loggedInPharmacy.getPharmacyName());

        return "pharmacy-dashboard";
    }

    // --- 4. MEDICINE MANAGEMENT ---

    @PostMapping("/add-medicine")
    public String addMedicine(@RequestParam String name,
            @RequestParam double price,
            @RequestParam int quantity,
            HttpSession session) {

        Pharmacy loggedInPharmacy = (Pharmacy) session.getAttribute("loggedInPharmacy");
        if (loggedInPharmacy == null)
            return "redirect:/pharmacy/login";

        Medicine medicine = new Medicine();
        medicine.setName(name);
        medicine.setPrice(price);
        medicine.setQuantity(quantity);
        medicine.setPharmacy(loggedInPharmacy); // Link medicine to the logged-in pharmacy!

        medicineService.save(medicine);
        return "redirect:/pharmacy/dashboard";
    }

    @GetMapping("/delete-medicine/{id}")
    public String deleteMedicine(@PathVariable Long id, HttpSession session) {
        if (session.getAttribute("loggedInPharmacy") == null)
            return "redirect:/pharmacy/login";

        medicineService.deleteMedicine(id);
        return "redirect:/pharmacy/dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Clear the session
        return "redirect:/";
    }
}