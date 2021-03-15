package com.yohanjoo.airportapi.controller;

import com.yohanjoo.airportapi.model.Airport;
import com.yohanjoo.airportapi.service.AirportRepositoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest Controller for airport
 * @author Yo Han Joo
 * @since 0.0.1-SNAPSHOT
 */
@RestController
@RequestMapping("/api/airports/")
public class AirportController {


    private final AirportRepositoryService airportRepositoryService;

    /**
     * Constructor for Controller
     * @param airportRepositoryService gets when spring loads
     */
    public AirportController(AirportRepositoryService airportRepositoryService) {
        this.airportRepositoryService = airportRepositoryService;
    }

    /**
     * Gets all airports
     * type: GET
     * mapping: "/api/airports/"
     * @return returns all airports from repository
     */
    @GetMapping("/")
    public List<Airport> getAllAirports() {
        return airportRepositoryService.findAll();
    }

    /**
     * Get airport with specifi ICAO code
     * type: GET
     * mapping: "/api/airports/ident/{ident}"
     * @return returns airport corresponding to ICAO code entered
     */
    @GetMapping("/ident/{ident}")
    public Airport getSpecificAirport(@PathVariable String ident) {
        return airportRepositoryService.findByIdent(ident);
    }

    /**
     * Get airports in a country
     * type: GET
     * mapping: "/api/airports/iso_country/{iso_country}"
     * @return returns list of airports in that country
     */
    @GetMapping("/iso_country/{iso_country}")
    public List<Airport> getAirportsByCountry(@PathVariable String iso_country) {
        return airportRepositoryService.findByIsoCountry(iso_country);
    }

    /**
     * Get distance between two airports
     * type: GET
     * mapping: "/api/airports/distance/{airport1_ident}/{airport2_ident}
     * @param ident1 ICAO of airport 1
     * @param ident2 ICAO of airport 2
     * @return nautical miles
     */
    @GetMapping("/distance/airport1_ident/airport2_ident")
    public int getDistanceBetweenTwoAirports(@PathVariable(name = "airport1_ident") String ident1, @PathVariable(name = "airport2_ident") String ident2) {
        return airportRepositoryService.distanceBetweenTwoAirports(ident1, ident2);
    }
}
