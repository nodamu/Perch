package com.nodamu.petch.models.property;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author profnick
 * 3/17/21
 **/

@ToString
@Builder
@Document(collection = "PropertyInfo")
public class Property {
    @Id
    private String id;

    private String propertyId;

    private String ownerId;

    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    private String propertyName;

    private int numRooms;

    private int numGuests;

    private int numLikes;

    private int numBeds;

    @Singular private List<String> amenities;
    @DBRef
    private Location location;
    @DBRef
    @Singular private List<Reviews> reviews;
    private LocalDateTime availableTime;

}
