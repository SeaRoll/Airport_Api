package com.yohanjoo.airportapi.controller;

import com.yohanjoo.airportapi.model.Airport;
import com.yohanjoo.airportapi.repository.AirportRepository;
import com.yohanjoo.airportapi.service.AirportRepositoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/airports/")
public class AirportController {

    private final AirportRepositoryService airportRepositoryService;

    public AirportController(AirportRepositoryService airportRepositoryService) {
        this.airportRepositoryService = airportRepositoryService;
    }

    @GetMapping("/")
    public List<Airport> getAllAirports() {
        return airportRepositoryService.findAll();
    }

    @GetMapping("/ident/{ident}")
    public Airport getSpecificAirport(@PathVariable String ident) {
        return airportRepositoryService.findByIdent(ident);
    }

    @GetMapping("/iso_country/{iso_country}")
    public List<Airport> getAirportsByCountry(@PathVariable String iso_country) {
        return airportRepositoryService.findByIsoCountry(iso_country);
    }
}
