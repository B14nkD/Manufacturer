package com.example.Manufacturer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

    public Manufacturer save(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    public Manufacturer findById(String id) {
        return manufacturerRepository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        manufacturerRepository.deleteById(id);
    }
}
