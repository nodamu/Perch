package com.nodamu.petch.repositories;

import com.nodamu.petch.models.property.Property;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author profnick
 * 3/18/21
 **/
@Repository
public interface PropertyRepository extends MongoRepository<Property,String>  {
    public List<Property> findByNumRooms(int numRooms);
}
