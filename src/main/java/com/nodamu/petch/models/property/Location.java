package com.nodamu.petch.models.property;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
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

    @Indexed(direction = IndexDirection.DESCENDING)
    private String countryName;

    @Indexed(direction = IndexDirection.DESCENDING)
    private String cityName;

    private double latitude;
    private double longitude;

    public Location(String countryName, String cityName, double latitude, double longitude) {
        this.countryName = countryName;
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
