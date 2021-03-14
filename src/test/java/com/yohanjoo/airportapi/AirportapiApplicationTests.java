package com.yohanjoo.airportapi;

import com.yohanjoo.airportapi.controller.AirportController;
import com.yohanjoo.airportapi.model.Airport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AirportapiApplicationTests {

    @Autowired
    private AirportController airportController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(airportController).isNotNull();
    }

    @Test
    public void shouldGetAllAirports() throws Exception {
        assertThat(airportController.getAllAirports()).isInstanceOf(List.class);
    }

    @Test
    public void shouldNotBeNullWithAnExistingCountry() throws Exception {
        assertThat(airportController.getAirportsByCountry("SE")).isInstanceOf(List.class);
    }

    @Test
    public void shouldGetNullByCountryThatDoesNotExist() throws Exception {
        assertThat(airportController.getAirportsByCountry("NANANANANA").contains(null));
    }


}
