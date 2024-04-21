package com.nasifproject.pcbuilder.admin;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
// takes care of all getter setter
@AllArgsConstructor
// creating a constructor that takes all these private field as argument
@NoArgsConstructor
@Document(collection = "admins")
public class Admin {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;

    // Constructors, Getters, and Setters
    // ...
}