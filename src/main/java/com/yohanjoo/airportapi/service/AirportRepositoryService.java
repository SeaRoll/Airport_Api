package com.yohanjoo.airportapi.service;

import com.yohanjoo.airportapi.model.Airport;
import com.yohanjoo.airportapi.repository.AirportRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles the manipulation of airport repository
 * @author Yo Han Joo
 * @since 0.0.1-SNAPSHOT
 */
@Service
public class AirportRepositoryService {

    private final AirportRepository airportRepository;

    /**
     * Constructor for AirportRepositoryService. called when Spring initiates
     * @param airportRepository loads when Spring starts
     */
    public AirportRepositoryService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    /**
     * Finds all Airports
     * @return List of all airports
     */
    public List<Airport> findAll() {
        return airportRepository.findAll();
    }

    /**
     * Searches airport by ICAO code
     * @param ident ICAO code of airport
     * @return Airport corresponding to ICAO code
     */
    public Airport findByIdent(String ident) {
        return airportRepository.findAll().stream()
                .filter(airport -> airport.getIdent().equals(ident))
                .findFirst()
                .orElse(null);
    }

    /**
     * Searches airports by ISO-country code.
     * @param iso_country 2-digit code of country
     * @return all airports in that country
     */
    public List<Airport> findByIsoCountry(String iso_country) {
        List<Airport> allAirports = findAll();
        allAirports = allAirports.stream()
                .filter(airport -> airport.getIso_country().equals(iso_country))
                .collect(Collectors.toList());
        return allAirports;
    }
}
