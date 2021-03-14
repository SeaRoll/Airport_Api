package com.yohanjoo.airportapi.database;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.yohanjoo.airportapi.model.Airport;
import com.yohanjoo.airportapi.repository.AirportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(AirportRepository repository) {
        try (CSVReader reader = new CSVReader(new FileReader("airports.csv"))) {
            List<String[]> r = reader.readAll();
            for(String[] x : r) {
                String[] coo = x[11].split(",");
                String airportType = x[1];
                if((coo.length > 1) && (airportType.equals("small_airport") || airportType.equals("medium_airport") || airportType.equals("large_airport"))) {
                    log.info("Saving airports to repository");
                    repository.save(new Airport(x[0], x[1], x[2], x[3], x[4], x[5], x[6], x[7], x[8], x[9], x[10], x[11]));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }

        return args -> {
            log.info("Preloaded database!");
        };
    }
}
