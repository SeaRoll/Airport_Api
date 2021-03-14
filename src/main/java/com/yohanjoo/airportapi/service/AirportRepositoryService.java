package com.yohanjoo.airportapi.service;

import com.yohanjoo.airportapi.model.Airport;
import com.yohanjoo.airportapi.repository.AirportRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportRepositoryService {
    private final AirportRepository airportRepository;

    public AirportRepositoryService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> findAll() {
        return airportRepository.findAll();
    }

    public Airport findByIdent(String ident) {
        return airportRepository.findAll().stream()
                .filter(airport -> airport.getIdent().equals(ident))
                .findFirst()
                .orElse(null);
    }

    public List<Airport> findByIsoCountry(String iso_country) {
        List<Airport> allAirports = findAll();
        allAirports = allAirports.stream()
                .filter(airport -> airport.getIso_country().equals(iso_country))
                .collect(Collectors.toList());
        return allAirports;
    }
}
