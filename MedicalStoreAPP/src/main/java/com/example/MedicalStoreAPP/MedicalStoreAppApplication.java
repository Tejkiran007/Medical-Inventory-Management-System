package com.example.MedicalStoreAPP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedicalStoreAppApplication {

	public static void main(String[] args) {

        SpringApplication.run(MedicalStoreAppApplication.class, args);

        System.out.println("🏥 Medical Store Backend is running!");
        System.out.println("📋 Access API at: http://localhost:8080/api/");
        System.out.println("👤 Default login: admin / admin123");
	}

}
