package com.example.aircompanymanagementsystem.dao;

import com.example.aircompanymanagementsystem.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDao extends JpaRepository<Flight, Long> {
    List<Flight> findAllByAirCompanyNameAndFlightStatus(String airCompanyName,
                                                        Flight.FlightStatus flightStatus);

    List<Flight> findAllByFlightStatusAndStartedFlightBefore(Flight.FlightStatus flightStatus,
                                                         LocalDateTime startedAt);

}
