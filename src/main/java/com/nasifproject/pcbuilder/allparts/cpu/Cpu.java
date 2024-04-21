package com.nasifproject.pcbuilder.allparts.cpu;

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
@Document(collection = "cpu")
public class Cpu {
    @Id
    private String id;
    private String name;
    private int wattage;
    private int cost;
    private String brand;
    private String imageLink;

    // Getters and Setters
}
