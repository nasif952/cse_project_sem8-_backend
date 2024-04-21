package com.nasifproject.pcbuilder;



import org.springframework.data.mongodb.repository.MongoRepository;

public interface PCComponentsRepository extends MongoRepository<PCComponents, String> {
}