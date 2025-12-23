package com.pharma.pharmaapp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "medicine")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brandCountry;
    private LocalDate expiryDate;
    private int quantity;
    private double price;
    private String imagePath;
    private int searchCount = 0; // The popularity counter

    @ManyToOne
    @JoinColumn(name = "pharmacy_id")
    private Pharmacy pharmacy;

    // Standard Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrandCountry() {
        return brandCountry;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public int getSearchCount() {
        return searchCount;
    } // Must match Service call

    // Standard Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrandCountry(String brandCountry) {
        this.brandCountry = brandCountry;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public void setSearchCount(int searchCount) {
        this.searchCount = searchCount;
    }
}