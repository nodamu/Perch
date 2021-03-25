package com.nodamu.petch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetchApplication {

    private Logger logger = LoggerFactory.getLogger(getClass());

//    @Autowired
//    private PropertyRepository propRepository;
//
//    @Autowired
//    private LocationRepository locationRepository;
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
//        Location loc = new Location("GH",7.946527,4.56563);
////        locationRepository.insert(loc);
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
//        Reviews reviews = new Reviews();
//        reviews.setComment("Very good service");
//        reviews.setDate(LocalDate.now());
//        reviews.setFirstName("Nicholas");
//        List<Reviews> revColl = new ArrayList<Reviews>();
//        revColl.add(reviews);
////        reviewRepository.save(reviews);
//        Property prop  =  Property.builder()
//                            .location(loc)
//                            .availableTime(LocalDateTime.now())
//                            .numBeds(2)
//                            .numLikes(5)
//                            .name("Nick Plaza")
//                            .numRooms(5)
//                            .ownerId("SD3434")
//                            .numGuests(5)
//                            .propertyId("A343353")
//                            .amenities(amenities)
//                            .reviews(revColl    )
//                            .build();
//      propRepository.findAll().forEach(System.out::println);
////      String country = propRepository.findById("605bbfdc5ca86507af650cfe").get().getLocation().getCountryName();
////      System.out.println(country);
////        propRepository.insert(prop);
//
//    }
}
