package com.example.MedicalStoreAPP.repository;


import com.example.MedicalStoreAPP.enity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine,Long> {
    List<Medicine> findByStockLessThan(Integer stock);

    List<Medicine> findByExpiryDateBefore(LocalDate date);

    @Query("SELECT m FROM Medicine m WHERE m.expiryDate BETWEEN ?1 AND ?2")
    List<Medicine> findExpiringMedicines(LocalDate startDate, LocalDate endDate);

    List<Medicine> findByNameContainingIgnoreCase(String name);

    void deleteAllById(Long id);
}

