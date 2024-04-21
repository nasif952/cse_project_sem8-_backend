package com.nasifproject.pcbuilder.allparts.monitor;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/monitor")
public class MonitorController {

    @Autowired
    private MonitorRepository monitorRepository;

    @GetMapping
    public ResponseEntity<List<Monitor>> getAllMonitors() {
        List<Monitor> monitors = monitorRepository.findAll();
        return ResponseEntity.ok(monitors);
    }

    @PostMapping
    public ResponseEntity<Monitor> addMonitor(@RequestBody Monitor monitor) {
        try {
            Monitor savedMonitor = monitorRepository.save(monitor);
            return ResponseEntity.ok(savedMonitor);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMonitor(@PathVariable String id) {
        try {
            monitorRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monitor> updateMonitor(@PathVariable String id, @RequestBody Monitor monitorDetails) {
        Optional<Monitor> monitorOptional = monitorRepository.findById(id);

        if (!monitorOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Monitor monitor = monitorOptional.get();
        monitor.setName(monitorDetails.getName());
        monitor.setBrand(monitorDetails.getBrand());
        monitor.setScreenSize(monitorDetails.getScreenSize());
        monitor.setResolution(monitorDetails.getResolution());
        monitor.setRefreshRate(monitorDetails.getRefreshRate());
        monitor.setCost(monitorDetails.getCost());
        monitor.setImageLink(monitorDetails.getImageLink());

        Monitor updatedMonitor = monitorRepository.save(monitor);
        return ResponseEntity.ok(updatedMonitor);
    }
}