package com.yohanjoo.airportapi.util;

import com.yohanjoo.airportapi.model.Airport;

import java.util.ArrayList;
import java.util.List;

/**
 * Performs calculations
 * @author Yo Han Joo
 * @since 0.0.2
 */
public class Calculations {

    /**
     * Calculates distance of two lat lon points and returns in nautical miles
     * @param lat1 latitude of airport 1
     * @param lon1 longitude of airport 1
     * @param lat2 latitude of airport 2
     * @param lon2 longitude of airport 2
     * @return nautical miles between airport 1 and 2
     */
    public static int calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final double RADIUS = 3440; // 3440 nautical miles.

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        // convert to radians
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // apply formulae
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(lat1) *
                        Math.cos(lat2);
        double rad = RADIUS;
        double c = 2 * Math.asin(Math.sqrt(a));
        return (int)(rad * c);
    }

    /**
     * Returns list of airports within set of distances
     * @param refAirport main airport
     * @param allAirports all airports
     * @param minDistance minimum distance
     * @param maxDistance maximum distance
     * @return list of airports within distance
     */
    public static List<Airport> AirportsWithinDistance(Airport refAirport, List<Airport> allAirports, int minDistance, int maxDistance) {
        List<Airport> airportsInDistance = new ArrayList<>();

        for(Airport airport : allAirports) {
            int distance = calculateDistance(refAirport.getLatitude(), refAirport.getLongitude(), airport.getLatitude(), airport.getLongitude());
            if(distance >= minDistance && distance <= maxDistance && !airport.equals(refAirport)) {
                airportsInDistance.add(airport);
            }
        }

        if(airportsInDistance.size() > 0)
            return airportsInDistance;
        else
            return null;
    }
}
