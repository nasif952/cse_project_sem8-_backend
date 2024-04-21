package com.nasifproject.pcbuilder.allparts.ram;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RAMRepository extends MongoRepository<RAM, String> {
    // You can add custom query methods here if needed
}
