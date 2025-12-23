package com.pharma.pharmaapp.repository;

import com.pharma.pharmaapp.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    // For searching snippets of names (Client/USSD search)
    List<Medicine> findByNameContainingIgnoreCase(String name);

    // Add this to MedicineRepository.java
    List<Medicine> findTop3ByOrderBySearchCountDesc();

    // For finding an EXACT name to update the search count (Popularity logic)
    // Change Optional<Medicine> to List<Medicine>
    List<Medicine> findByName(String name);
}