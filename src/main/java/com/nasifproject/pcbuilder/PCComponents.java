package com.nasifproject.pcbuilder;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "parts")
public class PCComponents {
    @Id
    private String id;
    private List<String> CPUs;
    private List<String> RAMs;
    private List<String> GPUs;
    private List<String> Motherboards;

    // Getters and Setters
}
