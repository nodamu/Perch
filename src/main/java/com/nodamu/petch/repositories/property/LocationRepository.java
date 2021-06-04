package com.nodamu.petch.repositories.property;

import com.nodamu.petch.models.property.Location;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author profnick
 * 3/22/21
 **/
@Repository
public interface LocationRepository extends MongoRepository<Location,String> {
    public List<Location> findByCoordinatesNear(Point coordinates, Distance distance);

    public List<Location> findByCityNameAndCoordinatesNear(String cityName,Point coordinates, Distance distance);
}
