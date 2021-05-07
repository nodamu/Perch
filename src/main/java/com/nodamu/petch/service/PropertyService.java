package com.nodamu.petch.service;

import com.nodamu.petch.dto.property.PropertyDto;
import com.nodamu.petch.models.property.Property;
import com.nodamu.petch.models.users.User;
import com.nodamu.petch.repositories.property.LocationRepository;
import com.nodamu.petch.repositories.property.PropertyRepository;
import com.nodamu.petch.repositories.property.ReviewsRepository;
import com.nodamu.petch.repositories.users.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.nodamu.petch.dto.mappers.PropertyMapper.toProperty;

/**
 * @author profnick
 * 3/25/21
 **/

@Service
public class PropertyService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final PropertyRepository propertyRepository;


    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    // Get properties by available date
    public List<Property> getAllPropertiesByDateAvailable(LocalDate date){
        Optional<List<Property>> properties = Optional.ofNullable(propertyRepository.findByAvailableDate(date));
        return properties.orElse(null);
    }

    // Adds a new Property to the database
    public Property addProperty(PropertyDto propertyDto){
        Property property = toProperty(propertyDto);
        logger.info("Property added with ID {}",property.getId());
        return this.propertyRepository.save(property);
    }

    // Get all properties by OwnerID
    public List<Property> getAllPropertiesByOwnerId(String ownerId) {
        logger.info("Property request for owner {}",ownerId);
        return this.propertyRepository.findPropertyByOwnerId(ownerId);
    }





}
