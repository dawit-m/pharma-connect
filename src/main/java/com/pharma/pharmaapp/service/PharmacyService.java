package com.pharma.pharmaapp.service;

import com.pharma.pharmaapp.entity.Medicine;
import com.pharma.pharmaapp.repository.MedicineRepository;
import com.pharma.pharmaapp.entity.Pharmacy;
import com.pharma.pharmaapp.repository.PharmacyRepository;
import org.springframework.stereotype.Service;

@Service
public class PharmacyService {

    private final PharmacyRepository pharmacyRepository;
    private MedicineRepository medicineRepository;


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
    public void addMedicine(String name, double price, int quantity) {
    Medicine medicine = new Medicine();
    medicine.setName(name);
    medicine.setPrice(price);
    medicine.setQuantity(quantity);

    medicineRepository.save(medicine);
}

}
