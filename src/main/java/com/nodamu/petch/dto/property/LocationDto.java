package com.nodamu.petch.dto.property;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author profnick
 * 3/25/21
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {
    @NotBlank
    private String countryName;

    @NotBlank
    private String cityName;

    private double latitude;
    private double longitude;
}
