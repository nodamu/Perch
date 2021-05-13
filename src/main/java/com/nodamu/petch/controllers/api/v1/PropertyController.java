package com.nodamu.petch.controllers.api.v1;

import com.nodamu.petch.dto.property.PropertyDto;
import com.nodamu.petch.models.property.Property;
import com.nodamu.petch.service.PropertyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<String> addProperty(@Valid @RequestBody PropertyDto propertyDto){
        String id = propertyService.addProperty(propertyDto).getId();
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

    @GetMapping("/getPropertyByAvailabeDate")
    public ResponseEntity<List<Property>> getAllPropertiesByDateAvailable(
            @RequestParam("availableDate") String availableDate){
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

}
