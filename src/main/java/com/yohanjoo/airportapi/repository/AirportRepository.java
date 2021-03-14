package com.yohanjoo.airportapi.repository;

import com.yohanjoo.airportapi.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository of Airport.
 * @author Yo Han Joo
 * @since 0.0.1-SNAPSHOT
 */
@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

}
