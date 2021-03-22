package com.nodamu.petch.repositories;

import com.nodamu.petch.models.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author profnick
 * 3/22/21
 **/
@Repository
public interface LocationRepository extends MongoRepository<Location,String> {
}
