package com.nodamu.petch.controllers.api.v1;

import com.nodamu.petch.dto.property.PropertyDto;
import com.nodamu.petch.models.property.Property;
import com.nodamu.petch.service.PropertyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author profnick
 * 5/12/21
 **/

@RestController
@RequestMapping({ "/petch/api/v1" })
@Api(value = "Property Controller", description = "APIs for the property management", tags = { "Property API" })
public class PropertyController {

   private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping("/property")
    public ResponseEntity<String> addProperty(@Valid @RequestBody PropertyDto propertyDto){
        String id = propertyService.addProperty(propertyDto).getId();
        return new ResponseEntity<String>(id, HttpStatus.OK);
    }
}
