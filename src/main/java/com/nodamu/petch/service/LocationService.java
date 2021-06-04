package com.nodamu.petch.service;

import com.nodamu.petch.models.property.Location;
import com.nodamu.petch.repositories.property.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author profnick
 * 6/4/21
 **/
@Service
public class LocationService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> findLocationNear(Point coordinates,Distance distance){
        return locationRepository.findByCoordinatesNear(coordinates,distance);
    }
}
