package com.nodamu.petch.repositories.property;

import com.nodamu.petch.models.property.Property;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author profnick
 * 3/18/21
 **/
@Repository
public interface PropertyRepository extends MongoRepository<Property,String>  {
    // Find Property by number of rooms
    public List<Property> findByNumRooms(int numRooms);

    @Override
    Optional<Property> findById(String s);

    Property findByPropertyName(String propertyName);

    @Query(value = "{'ownerId': ?0}")
    List<Property> findPropertyByOwnerId(String ownerId);

    List<Property> findByAvailableDate(LocalDate date);

}
