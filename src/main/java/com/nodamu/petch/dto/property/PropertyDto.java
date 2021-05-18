package com.nodamu.petch.dto.property;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

/**
 * @author profnick
 * 3/25/21
 **/

@Data
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertyDto {

    @NotBlank
    @Size(min = 4)
    private String propertyName;

    @Min(1)
    private int numRooms;

    private int numLikes;

    @Min(1)
    @NotNull
    private int numGuests;

    @Min(1)
    @NotNull
    private int numBeds;

    @NotEmpty
    @NotNull
    private List<String> amenities;

    private LocationDto location;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate availableDate;

}
