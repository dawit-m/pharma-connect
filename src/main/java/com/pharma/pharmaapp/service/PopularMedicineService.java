package com.pharma.pharmaapp.service;

import com.pharma.pharmaapp.entity.PopularMedicine;
import com.pharma.pharmaapp.repository.PopularMedicineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopularMedicineService {

    private final PopularMedicineRepository repository;

    public PopularMedicineService(PopularMedicineRepository repository) {
        this.repository = repository;
    }

    // Called whenever a medicine is searched
    public void recordSearch(String medicineName) {
        PopularMedicine med = repository.findByName(medicineName)
                .orElse(new PopularMedicine(medicineName));

        med.setSearchCount(med.getSearchCount() + 1);
        repository.save(med);
    }

    // Get top popular medicines
    public List<PopularMedicine> getPopularMedicines() {
        return repository.findAll();
    }
}
