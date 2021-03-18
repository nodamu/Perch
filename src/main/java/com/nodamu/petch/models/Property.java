package com.nodamu.petch.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author profnick
 * 3/17/21
 **/

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "PropertyInfo")
public class Property {
    @Id
    private String userId;
    private String name;
    private int numRooms;
    private int numGuests;
    private int numLikes;
    private int numBeds;
    @DBRef(lazy = true)
    private Location location;
}
