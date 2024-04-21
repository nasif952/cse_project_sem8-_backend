package com.nasifproject.pcbuilder;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/components")
public class PCComponentsController {

    @Autowired
    private PCComponentsRepository repository;

    @GetMapping
    public ResponseEntity<List<PCComponents>> getAllComponents() {
        List<PCComponents> components = repository.findAll();
        return ResponseEntity.ok(components);
    }
}
