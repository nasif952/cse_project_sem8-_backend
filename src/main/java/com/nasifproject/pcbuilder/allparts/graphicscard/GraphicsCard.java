package com.nasifproject.pcbuilder.allparts.graphicscard;

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
@Document(collection = "graphicscard")
public class GraphicsCard {
    @Id
    private String id;
    private String name;
    private String brand;
    private int gb;
    private int wattage;
    private int cost;
    private String imageLink;

    // Getters and Setters
}
