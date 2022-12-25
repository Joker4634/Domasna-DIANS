package com.example.pharmacies.service;

import com.example.pharmacies.model.Pharmacy;

import java.util.List;
import java.util.Optional;

public interface PharmacyService {
    List<Pharmacy> listAllPharmacies();
    List<Pharmacy> listAllPharmaciesByCity(String city);
    List<Pharmacy> findByContains(String city);
}
