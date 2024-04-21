package com.nasifproject.pcbuilder.allparts.ram;

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
@Document(collection = "ram")
public class RAM {
    @Id
    private String id;
    private String name;
    private int mhz;
    private int memory;
    private int cost;
    private String brand;
    private String imageLink;
    private int wattage;

    // Getters and Setters
}
