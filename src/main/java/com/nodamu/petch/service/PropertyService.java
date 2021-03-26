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

    private final UserRepository userRepository;

    public PropertyService(PropertyRepository propertyRepository, UserRepository userRepository) {
        this.propertyRepository = propertyRepository;
        this.userRepository = userRepository;
    }

    public List<Property> getAllPropertiesByDateAvailable(LocalDate date){
        Optional<List<Property>> properties = Optional.ofNullable(propertyRepository.findByAvailableDate(date));
        return properties.orElse(null);
    }

    // Adds a new Property to the database
    public Property addProperty(PropertyDto propertyDto){
        Property property = toProperty(propertyDto);
        Optional<User> user = userRepository.findById(propertyDto.getOwnerId());
        user.ifPresent(property::setOwner);
//        logger.debug("New property added :: {} , {}",property.getOwner().getId(), property.getId());
        return this.propertyRepository.save(property);
    }

    // Get all properties
    public List<Property> getAllProperties() {
        return this.propertyRepository.findAll();
    }




}
