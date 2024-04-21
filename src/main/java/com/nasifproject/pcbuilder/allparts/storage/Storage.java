package com.nasifproject.pcbuilder.allparts.storage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "storage")
public class Storage {
    @Id
    private String id;
    private String name;
    private String brand;
    private int capacity; // in GB or TB
    private int cost; // in your currency (e.g., USD)
    private int wattage; // power consumption in watts
    private String imageLink;
    private String type; // ssd or hdd

    // Getters and Setters
}
