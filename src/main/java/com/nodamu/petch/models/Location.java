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
@AllArgsConstructor
@Document(collection = "LocationInfo")
public class Location {
    @Id
    private String Id;
    private String countryName;
    private double latitude;
    private double longitude;


}
