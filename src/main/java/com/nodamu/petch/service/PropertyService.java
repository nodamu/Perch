package com.nodamu.petch.service;

import com.nodamu.petch.dto.property.PropertyDto;
import com.nodamu.petch.models.property.Location;
import com.nodamu.petch.models.property.Property;
import com.nodamu.petch.repositories.property.LocationRepository;
import com.nodamu.petch.repositories.property.PropertyRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.nodamu.petch.dto.mappers.LocationMapper.toLocation;
import static com.nodamu.petch.dto.mappers.PropertyMapper.toProperty;

/**
 * @author profnick
 * 3/25/21
 **/

@Service
public class PropertyService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final PropertyRepository propertyRepository;

    private final LocationRepository locationRepository;

    private final LocationService locationService;


    public PropertyService(PropertyRepository propertyRepository, LocationRepository locationRepository, LocationService locationService) {
        this.propertyRepository = propertyRepository;
        this.locationRepository = locationRepository;
        this.locationService = locationService;
    }

    // Get properties by available date
    public List<Property> getAllPropertiesByDateAvailable(LocalDate date){

        Optional<List<Property>> properties = Optional.ofNullable(propertyRepository.findByAvailableDate(date));
        return properties.orElse(null);
    }

    // Adds a new Property to the database
    @Transactional
    @PreAuthorize("hasRole('perch_host')")
    public Property addProperty(PropertyDto propertyDto,String ownerId){
        var location = new Location(propertyDto.getLocation().getCountryName(),
                                        propertyDto.getLocation().getCityName(),
                                        new GeoJsonPoint(propertyDto.getLocation().getLatitude()
                                        ,propertyDto.getLocation().getLongitude()));

        locationRepository.save(location);

        Property property = toProperty(propertyDto);
        property.setOwnerId(ownerId);
        property.setLocation(location);
        var newProp = this.propertyRepository.save(property);
        logger.info("Property added with ID {}",newProp.getId());
        return newProp;
    }

    // Get all properties by OwnerID
    public List<Property> getAllPropertiesByOwnerId(String ownerId) {
        logger.info("Property request for owner {}",ownerId);
        return this.propertyRepository.findPropertyByOwnerId(ownerId);  
    }

    // Update Property info
    @Transactional
    @PreAuthorize("hasAnyRole('perch_host','perch_admin')")
    public Property updateProperty(PropertyDto propertyDto, String propertyId) {
        var newProperty  = toProperty(propertyDto);
        var property = this.propertyRepository.findById(propertyId);
        if(property.isEmpty()){
            return null;
        }
        newProperty.setId(propertyId);
        newProperty.setLocation(toLocation(propertyDto,property.get().getLocation().getId()));
        locationRepository.save(newProperty.getLocation());
        logger.info("Updating property with id : {}",propertyId);
        return this.propertyRepository.save(newProperty);
    }

    // Delete property
    @Transactional
    @PreAuthorize("hasAnyRole('perch_host','perch_admin') and #ownerId == principal.subject")
    public void deleteProperty(String propertyId,@AuthenticationPrincipal Jwt principal,String ownerId){
        Optional<Property> prop = this.propertyRepository.findById(propertyId);
        if (prop.isPresent()){
            logger.info("Property with ID {} deleted", prop.get().getId());
            this.propertyRepository.delete(prop.get());
        }
    }

    public List<Property> findPropertyNear(double longitude, double latitude,String cityName,String countryName,double distance){
        Point point = new Point(longitude,latitude);
//        Location location = new Location(countryName,cityName,point);
        List<Location> locations = this.locationService.findLocationNear(point,new Distance(distance, Metrics.KILOMETERS));

        List<Property> props = locations.parallelStream()
                .map(this.propertyRepository::findByLocation)
                .collect(Collectors.toList());

        return props;
    }

}
