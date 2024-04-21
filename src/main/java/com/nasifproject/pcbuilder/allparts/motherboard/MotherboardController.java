package com.nasifproject.pcbuilder.allparts.motherboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/motherboard")
public class MotherboardController {

    @Autowired
    private MotherboardRepository motherboardRepository;

    @GetMapping
    public ResponseEntity<List<Motherboard>> getAllMotherboards() {
        List<Motherboard> motherboards = motherboardRepository.findAll();
        return ResponseEntity.ok(motherboards);
    }

    @PostMapping
    public ResponseEntity<Motherboard> addMotherboard(@RequestBody Motherboard motherboard) {
        try {
            Motherboard savedMotherboard = motherboardRepository.save(motherboard);
            return ResponseEntity.ok(savedMotherboard);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMotherboard(@PathVariable String id) {
        try {
            motherboardRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Motherboard> updateMotherboard(@PathVariable String id, @RequestBody Motherboard motherboardDetails) {
        Optional<Motherboard> motherboardOptional = motherboardRepository.findById(id);

        if (!motherboardOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Motherboard motherboard = motherboardOptional.get();
        motherboard.setName(motherboardDetails.getName());
        motherboard.setBrand(motherboardDetails.getBrand());
        motherboard.setWattage(motherboardDetails.getWattage());
        motherboard.setCost(motherboardDetails.getCost());
        motherboard.setPlatform(motherboardDetails.getPlatform());
        motherboard.setImageLink(motherboardDetails.getImageLink());

        Motherboard updatedMotherboard = motherboardRepository.save(motherboard);
        return ResponseEntity.ok(updatedMotherboard);
    }
}