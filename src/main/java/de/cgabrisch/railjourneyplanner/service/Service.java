package de.cgabrisch.railjourneyplanner.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("de.cgabrisch.railjourneyplanner.service")
public class Service {

    public static void main(String[] args) {
        SpringApplication.run(Service.class, args);
    }

}
