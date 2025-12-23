package com.pharma.pharmaapp.service;

import com.pharma.pharmaapp.entity.Medicine;
import com.pharma.pharmaapp.repository.MedicineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    private final MedicineRepository medicineRepository;

    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    // Save a new medicine (Used by the Dashboard)
    public Medicine save(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    // Get all medicines (Used by the Dashboard list)
    public List<Medicine> findAll() {
        return medicineRepository.findAll();
    }

    // Search logic used by both USSD and Web Client
    public List<Medicine> searchByName(String name) {
        // 1. Get ALL medicines with this exact name
        List<Medicine> exactMatches = medicineRepository.findAll().stream()
                .filter(m -> m.getName().equalsIgnoreCase(name))
                .toList();

        // 2. If we found any, update the searchCount for the first one
        if (!exactMatches.isEmpty()) {
            Medicine med = exactMatches.get(0);
            med.setSearchCount(med.getSearchCount() + 1);
            medicineRepository.save(med);
        }

        // 3. Return the results for the USSD/Web display (partial matches)
        return medicineRepository.findByNameContainingIgnoreCase(name);
    }

    // Get the Top 3 most searched medicines (For USSD Option 2)
    public List<Medicine> getTopMedicines() {
        return medicineRepository.findTop3ByOrderBySearchCountDesc();
    }

    // Delete medicine (Used by the Dashboard)
    public void deleteMedicine(Long id) {
        medicineRepository.deleteById(id);
    }
}