package com.nasifproject.pcbuilder.allparts.cpu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/cpu")
public class CpuController {

    @Autowired
    private CpuRepository cpuRepository;

    @GetMapping
    public ResponseEntity<List<Cpu>> getAllCPUs() {
        List<Cpu> cpuses = cpuRepository.findAll();
        return ResponseEntity.ok(cpuses);
    }

    @PostMapping
    public ResponseEntity<Cpu> addCPU(@RequestBody Cpu cpu) {
        try {
            Cpu savedCpu = cpuRepository.save(cpu);
            return ResponseEntity.ok(savedCpu);
        } catch (Exception e) {
            // Handle and log the exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
//for edit update
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCPU(@PathVariable String id) {
        try {
            cpuRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // Handle and log the exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cpu> updateCPU(@PathVariable String id, @RequestBody Cpu cpuDetails) {
        return cpuRepository.findById(id)
                .map(cpu -> {
                    cpu.setName(cpuDetails.getName());
                    cpu.setWattage(cpuDetails.getWattage());
                    cpu.setCost(cpuDetails.getCost());
                    cpu.setBrand(cpuDetails.getBrand());
                    cpu.setImageLink(cpuDetails.getImageLink());
                    Cpu updatedCpu = cpuRepository.save(cpu);
                    return ResponseEntity.ok(updatedCpu);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }







    // Additional endpoints for updating, deleting CPUs can be added here
}
