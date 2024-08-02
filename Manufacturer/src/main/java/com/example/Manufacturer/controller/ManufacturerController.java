package com.example.Manufacturer.controller;

import com.example.Manufacturer.entity.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerService.findAll();
    }

    @PostMapping
    public Manufacturer createManufacturer(@RequestBody Manufacturer manufacturer) {
        return manufacturerService.save(manufacturer);
    }

    @PutMapping("/{id}")
    public Manufacturer updateManufacturer(@PathVariable String id, @RequestBody Manufacturer manufacturerDetails) {
        Manufacturer manufacturer = manufacturerService.findById(id);
        if (manufacturer == null) {
            return null;
        }
        manufacturer.setName(manufacturerDetails.getName());
        manufacturer.setOrigin(manufacturerDetails.getOrigin());
        manufacturer.setDescription(manufacturerDetails.getDescription());
        return manufacturerService.save(manufacturer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteManufacturer(@PathVariable String id) {
        Manufacturer manufacturer = manufacturerService.findById(id);
        if (manufacturer == null || !manufacturer.getProducts().isEmpty()) {
            return ResponseEntity.badRequest().body("Cannot delete manufacturer with products");
        }
        manufacturerService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
