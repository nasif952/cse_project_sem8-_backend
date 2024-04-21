package com.nasifproject.pcbuilder.allparts.storage;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StorageRepository extends MongoRepository<Storage, String> {
    // You can add custom query methods here if needed
}
