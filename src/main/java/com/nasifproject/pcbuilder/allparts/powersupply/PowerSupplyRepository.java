package com.nasifproject.pcbuilder.allparts.powersupply;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PowerSupplyRepository extends MongoRepository<PowerSupply, String> {
}
