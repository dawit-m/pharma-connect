package com.pharma.pharmaapp.repository;

import com.pharma.pharmaapp.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional; // This import is crucial!

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {
    // This line tells Spring Boot how to find a pharmacy by username
    Optional<Pharmacy> findByUsername(String username);
}