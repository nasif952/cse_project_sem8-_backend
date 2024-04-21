package com.nasifproject.pcbuilder.allparts.powersupply;

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
@Document(collection = "powersupply")
public class PowerSupply {
    @Id
    private String id;
    private String name;
    private String brand;
    private int wattage;
    private int capacity;
    private int cost;
    private String imageLink;

    // Getters and Setters
}
