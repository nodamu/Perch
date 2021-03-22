package com.nodamu.petch.models;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

/**
 * @author profnick
 * 3/17/21
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "PropertyInfo")
public class Property {
    @Id
    private String propertyId;
    private String ownerId;
    private String name;
    private int numRooms;
    private int numGuests;
    private int numLikes;
    private int numBeds;
    @DBRef(lazy = false)
    private Location location;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
