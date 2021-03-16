package com.yohanjoo.airportapi;

import com.yohanjoo.airportapi.controller.AirportController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Main Application for testing purposes
 * @author Yo Han Joo
 * @since 0.0.1-SNAPSHOT
 */
@SpringBootTest
public class AirportapiApplicationTests {

    @Autowired
    private AirportController airportController;

    /**
     * Checks that airport controller loads in testing phase
     */
    @Test
    public void contextLoads() {
        assertThat(airportController).isNotNull();
    }

    /**
     * Checks that all airports should return List class
     */
    @Test
    public void shouldGetAllAirports() {
        assertThat(airportController.getAllAirports()).isInstanceOf(List.class);
    }

    /**
     * Checks that SE (Sweden) country returns a list
     */
    @Test
    public void shouldNotBeNullWithAnExistingCountry() {
        assertThat(airportController.getAirportsByCountry("SE")).isInstanceOf(List.class);
    }

    /**
     * Checks that it returns null if it's a non existing country
     */
    @Test
    public void shouldGetNullByCountryThatDoesNotExist() {
        assertThat(airportController.getAirportsByCountry("BANANA")).isNull();
    }

    /**
     * Checks that ESSA - EKCH should return Integer and is equal to 295NM
     */
    @Test
    public void shouldGetNmWithDistance() {
        System.out.println(airportController.getDistanceBetweenTwoAirports("ESSA", "EKCH"));
        assertThat(airportController.getDistanceBetweenTwoAirports("ESSA", "EKCH")).isInstanceOf(Integer.class);
        assertThat(airportController.getDistanceBetweenTwoAirports("ESSA", "EKCH")).isEqualTo(295);
    }

    /**
     * Checks that list should be returned with all regions
     */
    @Test
    public void shouldGetListWithNARegion() {
        assertThat(airportController.getAirportsByRegion("NA")).isInstanceOf(List.class);
    }


    /**
     * Checks that all continents returns a list
     */
    @Test
    public void shouldGetListWithAllContinents() {
        String[] regions = {
                "EU",
                "AS",
                "NA",
                "OC",
                "AF",
                "AN",
                "SA"
        };

        for (String region : regions) {
            assertThat(airportController.getAirportsByContinent(region)).isInstanceOf(List.class);
        }
    }
}
