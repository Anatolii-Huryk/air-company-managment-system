package com.example.aircompanymanagementsystem.service.impl;

import com.example.aircompanymanagementsystem.dao.FlightDao;
import com.example.aircompanymanagementsystem.model.Flight;
import com.example.aircompanymanagementsystem.service.FlightService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightDao flightDao;

    public FlightServiceImpl(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    @Override
    public Flight add(Flight flight) {
        if (flight.getFlightStatus().equals(Flight.FlightStatus.ACTIVE)) {
            flight.setStartedFlight(LocalDateTime.now());
        } else if (flight.getFlightStatus().equals(Flight.FlightStatus.COMPLETED)) {
            flight.setEndedFlight(LocalDateTime.now());
        } else if (flight.getFlightStatus().equals(Flight.FlightStatus.DELAYED)) {
            flight.setDelayStarted(LocalDateTime.now());
        } else {
            flight.setFlightStatus(Flight.FlightStatus.PENDING);
        }
        return flightDao.save(flight);
    }

    @Override
    public Flight get(Long id) {
        return flightDao.getById(id);
    }

    @Override
    public List<Flight> getAll() {
        return flightDao.findAll();
    }

    @Override
    public void delete(Long id) {
        flightDao.deleteById(id);
    }

    @Override
    public List<Flight> findAllByAirCompanyNameAndFlightStatus(String airCompanyName,
                                                                String flightStatus) {
        return flightDao.findAllByAirCompanyNameAndFlightStatus(airCompanyName,
                getFlightStatus(flightStatus));
    }

    @Override
    public List<Flight> findAllByFlightStatusAndStartedAtBefore() {
        return flightDao.findAllByFlightStatusAndStartedFlightBefore(Flight.FlightStatus.ACTIVE,
                LocalDateTime.now().minusDays(1).withNano(0));
    }

    @Override
    public List<Flight> findAllByDifferences(String status) {
        return null;
    }

    @Override
    public Flight update(Long id, String status) {
        Flight flight = get(id);
        flight.setFlightStatus(getFlightStatus(status));
        return add(flight);
    }

    private Flight.FlightStatus getFlightStatus(String status) {
        status = status.toLowerCase();
        Flight.FlightStatus flightStatus = Flight.FlightStatus.PENDING;
        if (status.equalsIgnoreCase("active")) {
            flightStatus = Flight.FlightStatus.ACTIVE;
        } else if (status.equalsIgnoreCase("completed")) {
            flightStatus = Flight.FlightStatus.COMPLETED;
        } else if (status.equalsIgnoreCase("delayed")) {
            flightStatus = Flight.FlightStatus.DELAYED;
        }
        return flightStatus;
    }
}
