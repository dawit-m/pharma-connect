package com.pharma.pharmaapp.repository;

import com.pharma.pharmaapp.entity.PopularMedicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PopularMedicineRepository extends JpaRepository<PopularMedicine, Long> {

    Optional<PopularMedicine> findByName(String name);
}
