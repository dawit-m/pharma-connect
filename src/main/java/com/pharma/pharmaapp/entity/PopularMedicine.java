package com.pharma.pharmaapp.entity;

import jakarta.persistence.*;

@Entity
public class PopularMedicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int searchCount;

    // Constructors
    public PopularMedicine() {}

    public PopularMedicine(String name) {
        this.name = name;
        this.searchCount = 1;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSearchCount() {
        return searchCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSearchCount(int searchCount) {
        this.searchCount = searchCount;
    }
}
