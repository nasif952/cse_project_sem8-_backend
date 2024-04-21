package com.nasifproject.pcbuilder.allparts.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/storage")
public class StorageController {

    @Autowired
    private StorageRepository storageRepository;

    @GetMapping
    public ResponseEntity<List<Storage>> getAllStorage() {
        List<Storage> storages = storageRepository.findAll();
        return ResponseEntity.ok(storages);
    }

    @PostMapping
    public ResponseEntity<Storage> addStorage(@RequestBody Storage storage) {
        try {
            Storage savedStorage = storageRepository.save(storage);
            return ResponseEntity.ok(savedStorage);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStorage(@PathVariable String id) {
        try {
            storageRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Additional endpoints for updating Storage can be added here
    @PutMapping("/{id}")
    public ResponseEntity<Storage> updateStorage(@PathVariable String id, @RequestBody Storage storageDetails) {
        try {
            Storage storage = storageRepository.findById(id).orElse(null);
            if (storage == null) {
                return ResponseEntity.notFound().build();
            }

            storage.setName(storageDetails.getName());
            storage.setBrand(storageDetails.getBrand());
            storage.setCapacity(storageDetails.getCapacity());
            storage.setCost(storageDetails.getCost());
            storage.setWattage(storageDetails.getWattage());
            storage.setImageLink(storageDetails.getImageLink());
            storage.setType(storageDetails.getType());

            Storage updatedStorage = storageRepository.save(storage);
            return ResponseEntity.ok(updatedStorage);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
