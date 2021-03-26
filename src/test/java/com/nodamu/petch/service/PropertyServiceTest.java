package com.nodamu.petch.service;

import com.nodamu.petch.dto.property.LocationDto;
import com.nodamu.petch.dto.property.PropertyDto;
import com.nodamu.petch.models.property.Property;
import com.nodamu.petch.models.users.User;
import com.nodamu.petch.repositories.property.PropertyRepository;
import com.nodamu.petch.repositories.users.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.nodamu.petch.dto.mappers.PropertyMapper.toProperty;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author profnick
 * 3/26/21
 **/


public class PropertyServiceTest {
    //Mock dependencies
    private final UserRepository userRepository = mock(UserRepository.class);
    private final PropertyRepository propertyRepository = mock(PropertyRepository.class);

    private final PropertyService propertyService = new PropertyService(propertyRepository,userRepository);

    @Test
    void saveNewProperty(){
        List<String> amenities = new ArrayList<>();
        amenities.add("Wifi");
        amenities.add("TV");
        amenities.add("Security");

        PropertyDto propertyDto = new PropertyDto();
        propertyDto.setNumRooms(3);
        propertyDto.setNumBeds(3);
        propertyDto.setNumLikes(0);
        propertyDto.setAvailableDate(LocalDate.now());
        propertyDto.setPropertyName("Nick Abode");
        propertyDto.setLocation(new LocationDto("Gh","Tema",1.1233,1.23333));
        propertyDto.setAmenities(amenities);

        User user = mock(User.class);

        when(userRepository.findById(any(String.class))).thenReturn(Optional.of(user));
        when(propertyRepository.save(any(Property.class))).thenReturn(toProperty(propertyDto));

        Property prop = propertyService.addProperty(propertyDto);
        assertThat(prop).isNotNull();
        assertThat(prop.getNumBeds()).isEqualTo(3);
        assertThat(prop.getAvailableDate()).isNotNull();
        assertThat(prop.getPropertyName()).isEqualTo("Nick Abode");
        assertThat(prop.getAmenities()).isInstanceOf(List.class);


    }
}
