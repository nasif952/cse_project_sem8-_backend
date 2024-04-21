//repository interface hoy

package com.nasifproject.pcbuilder;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuildsRepository extends MongoRepository<PcBuilds, ObjectId> {
    Optional<PcBuilds> findPcBuildsBybuildid(String buildid);
    //it takes a string id , and now it will search by the "id" that is string on the database
}
//mongo repository comes with builtin method for searching with id , but it doesnt not comes with searching others

