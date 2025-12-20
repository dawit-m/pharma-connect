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

    public Medicine save(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    public List<Medicine> search(String name) {
        return medicineRepository.findByNameContainingIgnoreCase(name);
    }
}
