package com.example.MedicalStoreAPP.service;


import com.example.MedicalStoreAPP.enity.Medicine;
import com.example.MedicalStoreAPP.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class MedicineService {
    @Autowired
    private MedicineRepository medicineRepository;

    public List<Medicine> getAllMedicines()
    {
        return medicineRepository.findAll();
    }

    public Medicine getMedicineById(Long id)
    {
        return medicineRepository.findById(id).orElse(null);
    }

    public Medicine saveMedicine(Medicine medicine)
    {
        return medicineRepository.save(medicine);
    }

    public Medicine updateMedicine(Medicine medicine)
    {
        return medicineRepository.save(medicine);
    }

    public void deleteMedicine(Long id)
    {
        medicineRepository.deleteAllById(id);
    }

    public List<Medicine> getLowStockMedicines()
    {
        return medicineRepository.findByStockLessThan(5);
    }

    public List<Medicine> getExpiringMedicines()
    {
        LocalDate today=LocalDate.now();
        LocalDate thirtyDaysLater = today.plusDays(30);
        return medicineRepository.findExpiringMedicines(today, thirtyDaysLater);
    }
}
