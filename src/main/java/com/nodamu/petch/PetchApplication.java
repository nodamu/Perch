package com.nodamu.petch;

import com.nodamu.petch.models.Location;
import com.nodamu.petch.models.Property;
import com.nodamu.petch.repositories.LocationRepository;
import com.nodamu.petch.repositories.PropertyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@SpringBootApplication
public class PetchApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PropertyRepository propRepository;

    @Autowired
    private LocationRepository locationRepository;

    public static void main(String[] args) {
        SpringApplication.run(PetchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Property prop = new Property();
        prop.setPropertyId("A112321");
        prop.setNumBeds(5);
        prop.setNumRooms(6);
        Location loc = new Location("GAHAN","GH",7.946527,4.56563);
        locationRepository.insert(loc);
        prop.setLocation(loc);
        prop.setEndTime(LocalDateTime.now());
        prop.setStartTime(LocalDateTime.now());
        prop.setNumGuests(3);
        prop.setOwnerId("A23456");

        propRepository.insert(prop);

//        List<Property> property =  propRepository.findByNumRooms(2);
        

    }
}
