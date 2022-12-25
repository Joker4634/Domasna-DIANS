package com.example.pharmacies.service.impl;

import com.example.pharmacies.model.Pharmacy;
import com.example.pharmacies.model.exception.CityNotFoundException;
import com.example.pharmacies.repository.PharmacyRepository;
import com.example.pharmacies.service.PharmacyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PharmacyServiceImpl implements PharmacyService {
    private final PharmacyRepository pharmacyRepository;

    public PharmacyServiceImpl(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    @Override
    public List<Pharmacy> listAllPharmacies() {
        return pharmacyRepository.findAll();
    }

    @Override
    public List<Pharmacy> listAllPharmaciesByCity(String city) {
        if (pharmacyRepository.findAllByCity(city) == null) {
            try {
               throw new CityNotFoundException("City could not be found!");
            } catch (CityNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        } else
            return pharmacyRepository.findAllByCity(city);
    }

    @Override
    public List<Pharmacy> findByContains(String city) {
        return pharmacyRepository.findAllByCityContains(city);
    }
}
