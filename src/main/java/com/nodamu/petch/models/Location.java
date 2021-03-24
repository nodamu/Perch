package com.nodamu.petch.models;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
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
    private String countryName;
    private double latitude;
    private double longitude;

    public Location(String countryName, double latitude, double longitude) {
        this.countryName = countryName;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
