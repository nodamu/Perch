package com.nodamu.petch.dto.mappers;

import com.nodamu.petch.dto.property.PropertyDto;
import com.nodamu.petch.models.property.Location;

/**
 * @author profnick
 * 5/13/21
 **/
public class LocationMapper {
    public static Location toLocation(PropertyDto propertyDto, String locationId) {
        var location = new Location(propertyDto.getLocation().getCountryName(),
                propertyDto.getLocation().getCityName(),
                propertyDto.getLocation().getLatitude(),
                propertyDto.getLocation().getLongitude());

        location.setId(locationId);

        return location;
    }
}
