package com.nodamu.petch.dto.mappers;

import com.nodamu.petch.dto.property.PropertyDto;
import com.nodamu.petch.models.property.Location;
import com.nodamu.petch.models.property.Property;

/**
 * @author profnick
 * 3/26/21
 **/
public  class PropertyMapper {
    public static Property toProperty(PropertyDto propertyDto){
        return  Property.builder()
                            .propertyName(propertyDto.getPropertyName())
                            .numBeds(propertyDto.getNumBeds())
                            .numLikes(propertyDto.getNumLikes())
                            .numRooms(propertyDto.getNumRooms())
                            .numGuests(propertyDto.getNumGuests())
                            .amenities(propertyDto.getAmenities())
                            .ownerId(propertyDto.getOwnerId())
                            .availableDate(propertyDto.getAvailableDate())
                            .location(new Location(
                                    propertyDto.getLocation().getCountryName(),
                                    propertyDto.getLocation().getCityName(),
                                    propertyDto.getLocation().getLatitude(),
                                    propertyDto.getLocation().getLatitude()
                                    ))
                            .build();
    }
}
