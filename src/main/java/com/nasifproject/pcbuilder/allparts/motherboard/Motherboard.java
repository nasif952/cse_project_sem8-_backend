package com.nasifproject.pcbuilder.allparts.motherboard;

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
@Document(collection = "motherboard")
public class Motherboard {
    @Id
    private String id;
    private String name;
    private String brand;
    private int wattage;
    private int cost;
    private String platform;
    private String imageLink;

    // Getters and Setters
}
