package com.nodamu.petch.models.property;

import com.nodamu.petch.models.users.User;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

/**
 * @author profnick
 * 3/17/21
 **/

@Getter
@Setter
@ToString
@Builder
@Document(collection = "PropertyInfo")
public class Property {
    @Id
    private String id;

    @DBRef
    private User owner;

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

    private LocalDate availableDate;

}
