package com.pharma.pharmaapp.service;

import com.pharma.pharmaapp.entity.Pharmacy;
import com.pharma.pharmaapp.repository.PharmacyRepository;
import org.springframework.stereotype.Service;

@Service
public class PharmacyService {

    private final PharmacyRepository pharmacyRepository;

    public PharmacyService(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    public Pharmacy register(Pharmacy pharmacy) {
        return pharmacyRepository.save(pharmacy);
    }
    public Pharmacy login(String username, String password){
        Pharmacy pharmacy = pharmacyRepository.findByUsername(username);
        if(pharmacy!=null && pharmacy.getPassword().equals(password)){
            return pharmacy;
        }
        return null;
    }
}
