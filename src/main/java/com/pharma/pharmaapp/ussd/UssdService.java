package com.pharma.pharmaapp.ussd;

import org.springframework.stereotype.Service;

@Service
public class UssdService {

    public String process(String sessionId, String text) {

        // FIRST SCREEN
        if (text == null || text.isEmpty()) {
            return """
                CON Welcome to PharmaFinder
                1. Search Medicine
                2. Popular Medicines
                """;
        }

        // OPTION 1: SEARCH MEDICINE
        if (text.equals("1")) {
            return "CON Enter medicine name:";
        }

        // USER ENTERS MEDICINE NAME
        if (text.startsWith("1*")) {
            String medicineName = text.substring(2);

            // For now: simulated response
            return """
                END Medicine Found:
                Paracetamol 500mg
                Pharmacy: Health Plus
                Location: Bole
                """;
        }

        // OPTION 2: POPULAR MEDICINES
        if (text.equals("2")) {
            return """
                END Popular Medicines:
                1. Paracetamol
                2. Amoxicillin
                3. Ibuprofen
                """;
        }

        return "END Invalid input";
    }
}