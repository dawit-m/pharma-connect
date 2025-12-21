package com.pharma.pharmaapp.controller;

import com.pharma.pharmaapp.service.MedicineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientController {

    private final MedicineService medicineService;

    public ClientController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping("/client/search")
    public String search(
            @RequestParam(required = false) String name,
            Model model) {

        if (name != null) {
            model.addAttribute("medicines",
                    medicineService.search(name));
        }

        return "client-search";
    }
}
