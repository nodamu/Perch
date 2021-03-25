package com.nodamu.petch.repositories.property;

import com.nodamu.petch.models.property.Property;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author profnick
 * 3/18/21
 **/
@Repository
public interface PropertyRepository extends MongoRepository<Property,String>  {
    // Find Property by number of rooms
    public List<Property> findByNumRooms(int numRooms);

    Property findByPropertyName(String propertyName);

    List<Property> findByAvailableDate(LocalDate date);

}
