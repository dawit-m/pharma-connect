package com.pharma.pharmaapp.repository;

import com.pharma.pharmaapp.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {
    Pharmacy findByUsername(String username);
}
