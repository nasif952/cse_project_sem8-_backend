package com.nasifproject.pcbuilder.allparts.powersupply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/powersupply")
public class PowerSupplyController {

    @Autowired
    private PowerSupplyRepository powerSupplyRepository;

    @GetMapping
    public ResponseEntity<List<PowerSupply>> getAllPowerSupplies() {
        List<PowerSupply> powerSupplies = powerSupplyRepository.findAll();
        return ResponseEntity.ok(powerSupplies);
    }

    @PostMapping
    public ResponseEntity<PowerSupply> addPowerSupply(@RequestBody PowerSupply powerSupply) {
        try {
            PowerSupply savedPowerSupply = powerSupplyRepository.save(powerSupply);
            return ResponseEntity.ok(savedPowerSupply);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePowerSupply(@PathVariable String id) {
        try {
            powerSupplyRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PowerSupply> updatePowerSupply(@PathVariable String id, @RequestBody PowerSupply powerSupplyDetails) {
        Optional<PowerSupply> powerSupplyOptional = powerSupplyRepository.findById(id);

        if (!powerSupplyOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        PowerSupply powerSupply = powerSupplyOptional.get();
        powerSupply.setName(powerSupplyDetails.getName());
        powerSupply.setBrand(powerSupplyDetails.getBrand());
        powerSupply.setWattage(powerSupplyDetails.getWattage());
        powerSupply.setCapacity(powerSupplyDetails.getCapacity());
        powerSupply.setCost(powerSupplyDetails.getCost());
        powerSupply.setImageLink(powerSupplyDetails.getImageLink());

        PowerSupply updatedPowerSupply = powerSupplyRepository.save(powerSupply);
        return ResponseEntity.ok(updatedPowerSupply);
    }
}