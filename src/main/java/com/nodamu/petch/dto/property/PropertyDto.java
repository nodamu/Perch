package com.nodamu.petch.dto.property;

import lombok.Data;

import java.util.List;

/**
 * @author profnick
 * 3/25/21
 **/

@Data
public class PropertyDto {
    private int numRooms;
    private int numLikes;
    private int numGuests;
    private int numBeds;
    private List<String> amenities;
}
