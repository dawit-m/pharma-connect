package com.pharma.pharmaapp.controller;

import com.pharma.pharmaapp.entity.Medicine;
import com.pharma.pharmaapp.service.MedicineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ClientController {

    private final MedicineService medicineService;

    public ClientController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }
    

    @GetMapping("/client/search")
public String search(@RequestParam String name, Model model) {

    if (name.equalsIgnoreCase("paracetamol")) {
        model.addAttribute("result", "Paracetamol is available at Health Plus Pharmacy");
    } else {
        model.addAttribute("result", "No medicine found");
    }

    return "client";
}

}
