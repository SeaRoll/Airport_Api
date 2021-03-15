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
     * @throws Exception if an error occurs
     */
    @Test
    public void contextLoads() throws Exception {
        assertThat(airportController).isNotNull();
    }

    /**
     * Checks that all airports should return List class
     * @throws Exception if an error occurs
     */
    @Test
    public void shouldGetAllAirports() throws Exception {
        assertThat(airportController.getAllAirports()).isInstanceOf(List.class);
    }

    /**
     * Checks that SE (Sweden) country returns a list
     * @throws Exception if an error occurs
     */
    @Test
    public void shouldNotBeNullWithAnExistingCountry() throws Exception {
        assertThat(airportController.getAirportsByCountry("SE")).isInstanceOf(List.class);
    }

    /**
     * Checks that it returns null if it's a non existing country
     * @throws Exception if an error occurs
     */
    @Test
    public void shouldGetNullByCountryThatDoesNotExist() throws Exception {
        assertThat(airportController.getAirportsByCountry("NANANANANA").contains(null));
    }

    /**
     * Checks that ESSA - EKCH should return Integer and is equal to 295NM
     * @throws Exception if an error occurs
     */
    @Test
    public void shouldGetNmWithDistance() throws Exception {
        System.out.println(airportController.getDistanceBetweenTwoAirports("ESSA", "EKCH"));
        assertThat(airportController.getDistanceBetweenTwoAirports("ESSA", "EKCH")).isInstanceOf(Integer.class);
        assertThat(airportController.getDistanceBetweenTwoAirports("ESSA", "EKCH")).isEqualTo(295);
    }
}
