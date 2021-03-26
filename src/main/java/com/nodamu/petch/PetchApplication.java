package com.nodamu.petch;

import com.nodamu.petch.dto.property.PropertyDto;
import com.nodamu.petch.models.property.Location;
import com.nodamu.petch.models.property.Property;
import com.nodamu.petch.models.users.Address;
import com.nodamu.petch.models.users.User;
import com.nodamu.petch.repositories.property.LocationRepository;
import com.nodamu.petch.repositories.users.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PetchApplication //implements CommandLineRunner
{

    private Logger logger = LoggerFactory.getLogger(getClass());

//    @Autowired
//    private PropertyRepository propRepository;
//
//    @Autowired
//    private LocationRepository locationRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private ReviewsRepository reviewRepository;

    public static void main(String[] args) {
        SpringApplication.run(PetchApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//
////        Property prop = new Property();
////        prop.setPropertyId("A112321");
////        prop.setNumBeds(5);
////        prop.setNumRooms(6);
//        Location loc = new Location("GH","Accra",7.946527,4.56563);
//        this.locationRepository.save(loc);
//
//        User user = new User();
//        user.setFirstName("Nicholas");
//        user.setEmail("nickadamu@gmail.com");
//        user.setAddress(new Address("0553321138","GN-315315","Anum,40"));
//        this.userRepository.save(user);



////        prop.setLocation(loc);
////        prop.setEndTime(LocalDateTime.now());
////        prop.setStartTime(LocalDateTime.now());
////        prop.setNumGuests(3);
////        prop.setOwnerId("A23456");
//////        propRepository.insert(prop);
//        List<String> amenities = new ArrayList<String>();
//        amenities.add("Wifi");
//        amenities.add("Kitchen");
//        amenities.add("Washer");
//        amenities.add("Iron");
////        Reviews reviews = new Reviews();
//        reviews.setComment("Very good service");
//        reviews.setDate(LocalDate.now());
//        reviews.setFirstName("Nicholas");
//        List<Reviews> revColl = new ArrayList<Reviews>();
//        revColl.add(reviews);
////        reviewRepository.save(reviews);
//        Property prop  =  Property.builder()
//                            .location(loc)
//                            .availableDate(LocalDate.now())
//                            .numBeds(2)
//                            .numLikes(5)
//                            .propertyName("Nick Suite")
//                            .numRooms(5)
//                            .owner( user)
//                            .numGuests(5)
//                            .amenities(amenities)
////                            .reviews(revColl    )
//                            .build();
//        PropertyDto propertyDto =
//      propRepository.findAll().forEach(System.out::println);
////      String country = propRepository.findById("605bbfdc5ca86507af650cfe").get().getLocation().getCountryName();
////      System.out.println(country);
////        propRepository.insert(prop);
//
//    }
}
