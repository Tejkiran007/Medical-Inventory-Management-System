package com.example.MedicalStoreAPP.scheduler;

import com.example.MedicalStoreAPP.entity.Medicine;
import com.example.MedicalStoreAPP.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlertScheduler {

    @Autowired
    private MedicineService medicineService;

    @Scheduled(cron = "0 0 9 * * ?")
    public void checkMedicineAlerts() {
        System.out.println("=== DAILY MEDICINE ALERTS ===");

        List<Medicine> lowStockMedicines = medicineService.getLowStockMedicines();
        if (!lowStockMedicines.isEmpty()) {
            System.out.println("⚠️ LOW STOCK ALERT:");
            for (Medicine medicine : lowStockMedicines) {
                System.out.println("- " + medicine.getName() +
                        " (Stock: " + medicine.getStock() + ")");
            }
        }

        // Check for expired medicines
        List<Medicine> expiredMedicines = medicineService.getExpiredMedicines();
        if (!expiredMedicines.isEmpty()) {
            System.out.println("🚨 EXPIRED MEDICINES:");
            for (Medicine medicine : expiredMedicines) {
                System.out.println("- " + medicine.getName() +
                        " (Expired: " + medicine.getExpiryDate() + ")");
            }
        }

        List<Medicine> expiringMedicines = medicineService.getExpiringMedicines();
        if (!expiringMedicines.isEmpty()) {
            System.out.println("⏰ EXPIRING SOON (within 30 days):");
            for (Medicine medicine : expiringMedicines) {
                System.out.println("- " + medicine.getName() +
                        " (Expires: " + medicine.getExpiryDate() + ")");
            }
        }

        if (lowStockMedicines.isEmpty() && expiredMedicines.isEmpty() && expiringMedicines.isEmpty()) {
            System.out.println("✅ All medicines are in good condition!");
        }

        System.out.println("==============================");
    }

    @Scheduled(fixedRate = 120000)
    public void testAlert() {
        System.out.println("🔄 Medicine alert system is running... " + java.time.LocalDateTime.now());
    }
}
