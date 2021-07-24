package com.nodamu.petch.service;

import com.nodamu.petch.dto.property.LocationDto;
import com.nodamu.petch.dto.property.PropertyDto;
import com.nodamu.petch.models.property.Property;
import com.nodamu.petch.models.users.User;
import com.nodamu.petch.repositories.property.LocationRepository;
import com.nodamu.petch.repositories.property.PropertyRepository;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.nodamu.petch.dto.mappers.PropertyMapper.toProperty;
import static com.nodamu.petch.dto.mappers.LocationMapper.toLocation;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author profnick
 * 3/26/21
 **/


public class PropertyServiceTest {
    //Mock dependencies
//    private final UserRepository userRepository = mock(UserRepository.class);
    private final PropertyRepository propertyRepository = mock(PropertyRepository.class);
    private final LocationRepository locationRepository = mock(LocationRepository.class);


    private final PropertyService propertyService = new PropertyService(propertyRepository,locationRepository, locationService);

    @Test
    void saveNewProperty(){
        List<String> amenities = new ArrayList<>();
        amenities.add("Wifi");
        amenities.add("TV");
        amenities.add("Security");

        PropertyDto propertyDto = new PropertyDto();
        propertyDto.setNumRooms(3);
        propertyDto.setNumBeds(3);
        propertyDto.setNumGuests(6);
        propertyDto.setNumLikes(0);
        propertyDto.setOwnerId("1234");
        propertyDto.setAvailableDate(LocalDate.now());
        propertyDto.setPropertyName("Nick Abode");
        propertyDto.setLocation(new LocationDto("Gh","Tema",1.233,1.233));
        propertyDto.setAmenities(amenities);

        var propSet = toProperty(propertyDto);
        propSet.setLocation(toLocation(propertyDto,""));

        User user = mock(User.class);

        when(userRepository.findById(any(String.class))).thenReturn(Optional.of(user));
        when(propertyRepository.save(any(Property.class))).thenReturn(propSet);

        Property prop = propertyService.addProperty(propertyDto,"1234");
        assertThat(prop).isNotNull();
        assertThat(prop.getNumBeds()).isEqualTo(3);
        assertThat(prop.getAvailableDate()).isNotNull();
        assertThat(prop.getPropertyName()).isEqualTo("Nick Abode");
        assertThat(prop.getAmenities()).isInstanceOf(List.class);
        assertThat(prop.getNumGuests()).isEqualTo(6);
        assertThat(prop.getLocation().getCountryName()).isEqualTo("Gh");
        assertThat(prop.getLocation().getCityName()).isEqualTo("Tema");
        assertThat(prop.getNumLikes()).isEqualTo(0);
        assertThat(prop.getNumRooms()).isEqualTo(3);
        assertThat(prop.getOwnerId()).isEqualTo("1234");
        assertThat(prop.getReviews()).isInstanceOf(List.class);

    }

    @Test
    void testGetAllPropertyByOwnerId(){
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
        propertyDto.setOwnerId("12345");

        List<Property> propList = List.of(toProperty(propertyDto));

        when(propertyRepository.findPropertyByOwnerId(anyString())).thenReturn(propList);

        List<Property> testPropList = propertyService.getAllPropertiesByOwnerId("1234");

        assertThat(testPropList).isInstanceOf(List.class);
        assertThat(testPropList).isNotEmpty();
    }

    @Test
    void testFindAllPropertyByAvailableDate(){
        List<String> amenities = new ArrayList<>();
        amenities.add("Wifi");
        amenities.add("TV");
        amenities.add("Security");

        PropertyDto propertyDto = new PropertyDto();
        propertyDto.setNumRooms(3);
        propertyDto.setNumBeds(3);
        propertyDto.setNumLikes(0);
        propertyDto.setAvailableDate(LocalDate.parse("2021-05-18"));
        propertyDto.setPropertyName("Nick Abode");
        propertyDto.setLocation(new LocationDto("Gh","Tema",1.1233,1.23333));
        propertyDto.setAmenities(amenities);
        propertyDto.setOwnerId("12345");

        List<Property> propList = List.of(toProperty(propertyDto));

        when(propertyRepository.findByAvailableDate(any(LocalDate.class))).thenReturn(propList);

        List<Property> testPropList = propertyService.getAllPropertiesByDateAvailable(LocalDate.of(2021,05,18));

        assertThat(testPropList).isInstanceOf(List.class);
        assertThat(testPropList).isNotEmpty();
        assertThat(testPropList.get(0).getAvailableDate()).isEqualTo(LocalDate.parse("2021-05-18"));


    }
}
