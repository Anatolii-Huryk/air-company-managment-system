package com.example.aircompanymanagementsystem.service;

import com.example.aircompanymanagementsystem.model.Flight;
import java.util.List;

public interface FlightService extends CustomService<Flight> {
    List<Flight> findAllByAirCompanyNameAndFlightStatus(String airCompanyName,
                                                         String flightStatus);

    List<Flight> findAllByFlightStatusAndStartedAtBefore();

    List<Flight> findAllByDifferences(String status);

    Flight update(Long id, String status);
}
