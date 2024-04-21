package com.nasifproject.pcbuilder.allparts.ram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/ram")
public class RAMController {

    @Autowired
    private RAMRepository ramRepository;

    @GetMapping
    public ResponseEntity<List<RAM>> getAllRams() {
        List<RAM> RAMS = ramRepository.findAll();
        return ResponseEntity.ok(RAMS);
    }

    @PostMapping
    public ResponseEntity<RAM> addRam(@RequestBody RAM ram) {
        try {
            RAM savedRam = ramRepository.save(ram);
            return ResponseEntity.ok(savedRam);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRam(@PathVariable String id) {
        try {
            ramRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RAM> updateRam(@PathVariable String id, @RequestBody RAM ramDetails) {
        Optional<RAM> ramOptional = ramRepository.findById(id);

        if (!ramOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        RAM ram = ramOptional.get();
        ram.setName(ramDetails.getName());
        ram.setBrand(ramDetails.getBrand());
        ram.setMhz(ramDetails.getMhz());
        ram.setMemory(ramDetails.getMemory());
        ram.setCost(ramDetails.getCost());
        ram.setImageLink(ramDetails.getImageLink());
        ram.setWattage(ramDetails.getWattage());

        RAM updatedRam = ramRepository.save(ram);
        return ResponseEntity.ok(updatedRam);
    }
}
//⚠️FOR WEIRD REASON IF I CHANGE THE FILE NAME TO Ram , it doesnt  work , not yet sure why