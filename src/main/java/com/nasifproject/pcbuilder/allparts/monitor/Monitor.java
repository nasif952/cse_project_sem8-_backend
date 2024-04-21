package com.nasifproject.pcbuilder.allparts.monitor;

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
@Document(collection = "monitor")
public class Monitor {
    @Id
    private String id;
    private String name;
    private String brand;
    private String resolution;
    private int screenSize;
    private int refreshRate;
    private int cost;
    private int wattage;
    private String imageLink;

    // Getters and Setters
}
