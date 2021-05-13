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
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PetchApplication
{

    public static void main(String[] args) {
        SpringApplication.run(PetchApplication.class, args);
    }


}
