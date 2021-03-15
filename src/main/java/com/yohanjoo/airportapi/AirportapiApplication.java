package com.yohanjoo.airportapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Main Application
 * @author Yo Han Joo
 * @since 0.0.1-SNAPSHOT
 */
@EnableCaching
@SpringBootApplication
public class AirportapiApplication {

    /**
     * Starts the program
     *
     * @author              Yo Han Joo
     * @param args          Arguments when Application starts
     * @since               0.0.1-SNAPSHOT
     */
    public static void main(String[] args) {
        SpringApplication.run(AirportapiApplication.class, args);
    }
}
