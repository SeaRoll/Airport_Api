package com.yohanjoo.airportapi.service;

import com.yohanjoo.airportapi.model.Airport;
import com.yohanjoo.airportapi.repository.AirportRepository;
import com.yohanjoo.airportapi.util.Calculations;
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

        if(allAirports.size() > 0)
            return allAirports;
        else
            return null;
    }

    /**
     * Searches airports by ISO-Region (region) code
     * @param iso_region 2-digit code of region
     * @return all airports in that region
     */
    public List<Airport> findByIsoRegion(String iso_region) {
        List<Airport> allAirports = findAll();
        allAirports = allAirports.stream()
                .filter(airport -> airport.getIso_region().equals(iso_region))
                .collect(Collectors.toList());
        return allAirports;
    }

    /**
     * Searches for airports with continent (2-code)
     * @param continent 2-digit code of continent
     * @return all airports in that continent
     */
    public List<Airport> findByContinent(String continent) {
        List<Airport> allAirports = findAll();
        allAirports = allAirports.stream()
                .filter(airport -> airport.getIso_region().equals(continent))
                .collect(Collectors.toList());
        return allAirports;
    }

    /**
     * Converts idents to airport objects and return distance between them
     * @param ident1 Airport 1 ICAO
     * @param ident2 Airport 2 ICAO
     * @return distance in nautical miles
     */
    public int distanceBetweenTwoAirports(String ident1, String ident2) {
        Airport airport1 = findByIdent(ident1);
        Airport airport2 = findByIdent(ident2);
        return Calculations.calculateDistance(airport1.getLatitude(), airport1.getLongitude(), airport2.getLatitude(), airport2.getLongitude());
    }

    /**
     * Returns all airports with distance in NM
     * @param refAirportIdent reference airport ICAO code
     * @param minDistance minimum distance
     * @param maxDistance maximum distance
     * @return airports within distance
     */
    public List<Airport> airportsInDistance(String refAirportIdent, int minDistance, int maxDistance) {
        Airport refAirport = findByIdent(refAirportIdent);
        return Calculations.AirportsWithinDistance(refAirport, findAll(), minDistance, maxDistance);
    }
}
