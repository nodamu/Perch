package com.nodamu.petch.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author profnick
 * 3/18/21
 **/
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "LocationInfo")
public class Location {
    @Id
    private String Id;
    private String countryName;
    private double latitude;
    private double longitude;
}
