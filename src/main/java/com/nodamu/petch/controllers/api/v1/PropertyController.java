package com.nodamu.petch.controllers.api.v1;

import com.nodamu.petch.dto.property.PropertyDto;
import com.nodamu.petch.models.property.Property;
import com.nodamu.petch.service.PropertyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author profnick
 * 5/12/21
 **/

@RestController
@RequestMapping({ "/petch/api/v1/property" })
@Api(value = "Property Controller", description = "APIs for the property management", tags = { "Property API" })
public class PropertyController {

   private final PropertyService propertyService;


    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping
    public ResponseEntity<String> addProperty(@Valid @RequestBody PropertyDto propertyDto,
                                              @ApiParam(hidden = true) @AuthenticationPrincipal Jwt principal){

        String id = propertyService.addProperty(propertyDto,principal.getSubject()).getId();
        return new ResponseEntity<String>(id, HttpStatus.OK);
    }

    @GetMapping("/getPropertyByOwnerId")
    public ResponseEntity<List<Property>> getAllPropertiesByOwnerId(@RequestParam("ownerId") String ownerId){
        List<Property> properties = propertyService.getAllPropertiesByOwnerId(ownerId);
        if(!properties.isEmpty()){
            return ResponseEntity.ok().body(properties);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getPropertyByAvailableDate")
    public ResponseEntity<List<Property>> getAllPropertiesByDateAvailable(
            @RequestParam("availableDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @FutureOrPresent(message = "Date must be current or in the future")
            LocalDate availableDate){
        List<Property> properties = propertyService.getAllPropertiesByDateAvailable(availableDate);
        if(!properties.isEmpty()){
            return ResponseEntity.ok().body(properties);
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateProperty")
    public ResponseEntity<Property> updateProperty(@Valid @RequestBody PropertyDto propertyDto,
                                                   @RequestParam("propertyId") String propertyId){
        var property = propertyService.updateProperty(propertyDto,propertyId);

        return ResponseEntity.ok().body(property);
    }

    // TODO run test for this endpoint
    @DeleteMapping("/deleteProperty/{propertyId}")
    public void deleteProperty(
            @NotEmpty @PathVariable String propertyId,
            @NotEmpty @RequestParam("ownerId") String ownerId,
           @ApiParam(hidden = true) @AuthenticationPrincipal Jwt principal){
        this.propertyService.deleteProperty(propertyId,principal,ownerId);
        }

    @GetMapping("/getPropertyByLocation")
    public ResponseEntity<List<Property>> findPropertyNear(
                                            @RequestParam("latitude") double latitude,
                                            @RequestParam("longitude") double longitude,
                                            @RequestParam("cityName") String cityName,
                                            @RequestParam("countryName") String countryName,
                                            @RequestParam("distance") double distance
                                                           ){
       List<Property> properties = this.propertyService.findPropertyNear(latitude,longitude,cityName,countryName,distance);

       return ResponseEntity.ok(properties);
    }

}
