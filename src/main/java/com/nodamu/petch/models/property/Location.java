package com.nodamu.petch.models.property;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author profnick
 * 3/18/21
 **/
@Data
@NoArgsConstructor
@Document(collection = "LocationInfo")
public class Location {
    @Id
    private String id;

    @Indexed(name = "country_name_index",direction = IndexDirection.DESCENDING)
    private String countryName;

    @Indexed(name="city_name_index",direction = IndexDirection.DESCENDING)
    private String cityName;

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint coordinates;

    public Location(String countryName, String cityName, GeoJsonPoint coordinates) {
        this.countryName = countryName;
        this.cityName = cityName;
        this.coordinates = coordinates;
    }
}
