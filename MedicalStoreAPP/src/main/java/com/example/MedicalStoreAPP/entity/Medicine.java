package com.example.MedicalStoreAPP.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String batchNumber;
    private Integer stock;
    private Double price;
    private LocalDate expiryDate;
    private LocalDate createdDate;


    public Medicine() {
        this.createdDate = LocalDate.now();
    }

    public Medicine(String name, String batchNumber, Integer stock, Double price, LocalDate expiryDate) {
        this.name = name;
        this.batchNumber = batchNumber;
        this.stock = stock;
        this.price = price;
        this.expiryDate = expiryDate;
        this.createdDate = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
